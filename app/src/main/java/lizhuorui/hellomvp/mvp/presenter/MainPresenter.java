package lizhuorui.hellomvp.mvp.presenter;

import lizhuorui.hellomvp.bean.Gank;
import lizhuorui.hellomvp.mvp.contract.MainContract;
import lizhuorui.hellomvp.mvp.model.MainModel;
import rx.Subscriber;
import rx.Subscription;

/**
 * Presnter桥梁
 *      连接Model和View的桥梁
 */
public class MainPresenter extends MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        mView = view;
        mModel = new MainModel();
    }

    @Override
    public void getGank() {

        Subscription subscribe = mModel.getGank()
                .subscribe(new Subscriber<Gank>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onFail(e.getMessage());
                        onCompleted();
                    }

                    @Override
                    public void onNext(Gank gank) {
                        mView.onSucceed(gank);
                    }
                });


        addSubscribe(subscribe);
    }
}
