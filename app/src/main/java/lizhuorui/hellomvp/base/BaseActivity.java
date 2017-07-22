package lizhuorui.hellomvp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 *  BaseActivity中的封装
 * @param <P>
 *     通过泛型确定一个Presenter的类型，
 *     然后使用抽象方法onCreatePresenter对其进行赋值，
 *     最后在onDestroy方法中进行资源的释放。
 *     继承这个BaseActivity类的Activity，就不用每次都在onDestroy进行同样的操作啦~达到简洁的目的
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (onCreatePresenter() != null) {
            mPresenter = onCreatePresenter();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    protected abstract P onCreatePresenter();
}
