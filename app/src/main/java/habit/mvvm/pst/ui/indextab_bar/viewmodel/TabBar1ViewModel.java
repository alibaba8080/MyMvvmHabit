package habit.mvvm.pst.ui.indextab_bar.viewmodel;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import habit.mvvm.pst.BR;
import habit.mvvm.pst.R;
import habit.mvvm.pst.ui.base.viewmodel.ToolbarViewModel;
import habit.mvvm.pst.ui.scan.ScanFragment;
import habit.mvvm.pst.ui.viewpager.adapter.ViewPagerBindingAdapter;
import habit.mvvm.pst.ui.viewpager.viewmodel.ViewPagerItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;


public class TabBar1ViewModel extends ToolbarViewModel {
    public SingleLiveEvent<String> itemClickEvent = new SingleLiveEvent<>();

    public TabBar1ViewModel(@NonNull Application application) {
        super(application);

        initToolbar();

        for (int i = 1; i <= 3; i++) {
            ViewPagerItemViewModel itemViewModel = new ViewPagerItemViewModel(application);
            items.add(itemViewModel);
        }
    }


    /**
     * 初始化Toolbar
     */
    public void initToolbar() {
        //初始化标题栏
        setTitleText("表单提交");
        setRightIcon(R.mipmap.btn_icon_scan);
    }

    @Override
    public void rightTextOnClick() {
        ToastUtils.showShort("更多");
    }

    @Override
    protected void rightIconOnClick() {
        super.rightIconOnClick();
        startContainerActivity(ScanFragment.class.getCanonicalName());
    }


    //给ViewPager添加ObservableList
    public ObservableList<ViewPagerItemViewModel> items = new ObservableArrayList<>();
    //给ViewPager添加ItemBinding
    public ItemBinding<ViewPagerItemViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.item_viewpager);
    //给ViewPager添加PageTitle
    public final BindingViewPagerAdapter.PageTitles<ViewPagerItemViewModel> pageTitles = new BindingViewPagerAdapter.PageTitles<ViewPagerItemViewModel>() {
        @Override
        public CharSequence getPageTitle(int position, ViewPagerItemViewModel item) {
            return "条目" + position;
        }
    };
    //给ViewPager添加Adpter，使用自定义的Adapter继承BindingViewPagerAdapter，重写onBindBinding方法
    public final ViewPagerBindingAdapter adapter = new ViewPagerBindingAdapter();
    //ViewPager切换监听
    public BindingCommand<Integer> onPageSelectedCommand = new BindingCommand<>(new BindingConsumer<Integer>() {
        @Override
        public void call(Integer index) {
            ToastUtils.showShort("ViewPager切换：" + index);
        }
    });
}
