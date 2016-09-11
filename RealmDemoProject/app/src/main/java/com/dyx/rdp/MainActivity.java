package com.dyx.rdp;

import android.os.Bundle;
import android.widget.Button;

import com.dyx.rdp.base.BaseActivity;
import com.dyx.rdp.model.Dog;
import com.dyx.rdp.model.Person;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_start)
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_start)
    public void onClick() {
        handleData();
    }

    private void handleData() {
        /**
         * 创建对象
         */
        Dog dog = new Dog();
        dog.setName("啦啦");
        dog.setAge(1);

        /**
         * 创建RealmConfiguration
         */
        RealmConfiguration configuration = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(configuration);

        /**
         * 获取Realm实例为当前线程
         */
        Realm realm = Realm.getDefaultInstance();

        /**
         * 数据查询
         */
        final RealmResults<Dog> results = realm.where(Dog.class).lessThan("age", 2).findAll();
        results.size();


        /**
         * 执行事务
         */
        realm.beginTransaction();
        final Dog managedDog = realm.copyToRealm(dog);
        Person person = realm.createObject(Person.class);
        person.getDogs().add(managedDog);
        realm.commitTransaction();

        /**
         * 为查询结果添加监听器
         */
        results.addChangeListener(new RealmChangeListener<RealmResults<Dog>>() {
            @Override
            public void onChange(RealmResults<Dog> element) {
                showToast(results.size() + "");
            }
        });

        /**
         * TODO 在子线程异步更新(https://realm.io/docs/java/latest/)
         */
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //执行事务
                Dog dog1 = realm.where(Dog.class).equalTo("age", 1).findFirst();
                dog1.setAge(3);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                //执行成功
                showToast("成功：" + results.size() + "\n" + "年龄为：" + managedDog.getAge());
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                //执行失败
            }
        });
    }
}
