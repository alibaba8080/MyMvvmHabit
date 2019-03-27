package habit.mvvm.pst.ui.indextab_bar.vm;

import android.app.Application;
import android.support.annotation.NonNull;
import android.view.View;

import habit.mvvm.pst.ui.base.viewmodel.ToolbarViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;

public class TabBar1ViewModel extends ToolbarViewModel {
    public TabBar1ViewModel(@NonNull Application application) {
        super(application);
        initToolbar();
    }


    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setRightIconVisible(View.VISIBLE);
        setTitleText("表单提交");
    }

    @Override
    public void rightTextOnClick() {
        ToastUtils.showShort("更多");
    }

    @Override
    protected void rightIconOnClick() {
        super.rightIconOnClick();

    }
}
