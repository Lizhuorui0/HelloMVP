package lizhuorui.hellomvp.mvp.contract;

import lizhuorui.hellomvp.base.BaseModel;
import lizhuorui.hellomvp.base.BasePresenter;
import lizhuorui.hellomvp.base.BaseView;
import lizhuorui.hellomvp.bean.Gank;
import rx.Observable;

/**
 * 契约类
 */
public interface MainContract {

    interface View extends BaseView {

        void showDialog();

        void onSucceed(Gank data);

        void onFail(String err);

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<Gank> getGank();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getGank();
    }
}
