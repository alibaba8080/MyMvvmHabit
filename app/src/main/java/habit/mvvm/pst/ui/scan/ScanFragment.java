package habit.mvvm.pst.ui.scan;

import android.Manifest;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.rbj.zxing.decode.QrcodeDecode;
import com.tbruyelle.rxpermissions2.RxPermissions;

import habit.mvvm.pst.BR;
import habit.mvvm.pst.R;
import habit.mvvm.pst.databinding.FragmentScanBinding;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Created by goldze on 2018/7/18.
 */

public class ScanFragment extends BaseFragment<FragmentScanBinding,ScanViewModel> {

    private FragmentScanBinding scanBinding;
    private QrcodeDecode qd;
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_scan;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();

        Window window = this.getActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        requestCameraPermissions();
        scanBinding=binding;
        qd = new QrcodeDecode(this.getActivity(), scanBinding.capturePreview, scanBinding.captureCropView) {

            @Override
            public void handleDecode(Bundle bundle) {
                // 扫描成功后调用
                doCode(bundle.getString(QrcodeDecode.BARCODE_RESULT));
//                stopScan();
            }
        };
    }

    // 得到二维码 处理二维码
    public void doCode(String code) {
        System.out.println(code);

    }

    @Override
    public void onResume() {
        super.onResume();
        // 在此处开起扫描
        this.startScan();
    }

    @Override
    public void onPause() {
        // 在此处暂停扫描
        this.stopScan();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        // 释放资源
        qd.onDestroy();
        super.onDestroy();
    }


    /**
     * 请求相机权限
     */
    @SuppressLint("CheckResult")
    private void requestCameraPermissions() {
        //请求打开相机权限
        RxPermissions rxPermissions = new RxPermissions(ScanFragment.this.getActivity());
        rxPermissions.request(Manifest.permission.CAMERA)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            ToastUtils.showShort("相机权限已经打开，直接跳入相机");
                        } else {
                            ToastUtils.showShort("权限被拒绝");
                        }
                    }
                });
    }

    // 开始扫描
    public void startScan() {
        qd.onResume();

        scanBinding.captureScanLine.clearAnimation();
        scanBinding.captureScanLine.setVisibility(View.VISIBLE);
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.9f);
        animation.setDuration(4500);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(Animation.RESTART);
        scanBinding.captureScanLine.startAnimation(animation);
    }

    // 停止扫描
    public void stopScan() {
        qd.onPause();

        scanBinding.captureScanLine.clearAnimation();
        AlphaAnimation animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(400);
        animation.setRepeatCount(0);
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                scanBinding.captureScanLine.clearAnimation();
                scanBinding.captureScanLine.setVisibility(View.INVISIBLE);
            }
        });
        scanBinding.captureScanLine.startAnimation(animation);

    }
}
