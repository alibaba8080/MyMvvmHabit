package habit.mvvm.pst.ui.viewpager.viewmodel;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import habit.mvvm.pst.BR;
import habit.mvvm.pst.R;
import habit.mvvm.pst.ui.recycleview.MultiRecycleHeadViewModel;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * 所有例子仅做参考,千万不要把它当成一种标准,毕竟主打的不是例子,业务场景繁多,理解如何使用才最重要。
 * Created by goldze on 2018/7/18.
 */

public class ViewPagerItemViewModel extends BaseViewModel{


    public ViewPagerItemViewModel(@NonNull Application application) {
        super(application);
        observableList.add(new MultiRecycleHeadViewModel(this));
        observableList.add(new MultiRecycleHeadViewModel(this));
        observableList.add(new MultiRecycleHeadViewModel(this));
        observableList.add(new MultiRecycleHeadViewModel(this));
        observableList.add(new MultiRecycleHeadViewModel(this));
        observableList.add(new MultiRecycleHeadViewModel(this));
        observableList.add(new MultiRecycleHeadViewModel(this));
        observableList.add(new MultiRecycleHeadViewModel(this));

    }

    //给RecyclerView添加ObservableList
    public ObservableList<MultiItemViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<MultiItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<MultiItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, MultiItemViewModel item) {
                //设置头布局
                itemBinding.set(BR.viewModel, R.layout.item_multi_head);
        }
    });


}
