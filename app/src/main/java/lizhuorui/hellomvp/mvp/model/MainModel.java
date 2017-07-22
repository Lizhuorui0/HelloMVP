package lizhuorui.hellomvp.mvp.model;

import lizhuorui.hellomvp.api.ApiEngine;
import lizhuorui.hellomvp.bean.Gank;
import lizhuorui.hellomvp.mvp.contract.MainContract;
import lizhuorui.hellomvp.rx.RxSchedulers;
import rx.Observable;

/**
 * Model处理数据
 *      Model分出来，而不在Presenter处理，
 *      其实也是为了简洁，当你要处理很多数据的时候，Presenter就会变得很乱了。
 */
public class MainModel implements MainContract.Model {

    @Override
    public Observable<Gank> getGank() {
        return ApiEngine.getInstance().getApiService()
                .getGank("1")
                .compose(RxSchedulers.<Gank>switchThread());
    }
}
