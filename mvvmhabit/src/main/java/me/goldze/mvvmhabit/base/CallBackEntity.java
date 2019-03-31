package me.goldze.mvvmhabit.base;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.http.BaseResponse;
import me.goldze.mvvmhabit.utils.ToastUtils;

public abstract class CallBackEntity<T>  {

    public Consumer<BaseResponse<T>> consumer=new Consumer<BaseResponse<T>>() {
        @Override
        public void accept(BaseResponse<T> baseResponse) throws Exception {
            if (baseResponse.getCode()==1){
                onSuccess(baseResponse.getResult());
            }else {
                onError(baseResponse.getCode()+" "+baseResponse.getMessage());
                ToastUtils.showShort("数据错误");
            }
        }
    };




    public abstract void onSuccess(T t);

    public abstract void onError(String err);
    public abstract void onFinish();
}
