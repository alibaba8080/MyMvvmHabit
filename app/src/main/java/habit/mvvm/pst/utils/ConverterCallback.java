package habit.mvvm.pst.utils;



    /**
     * <pre>
     *     author : ylw
     *     e-mail : bigoatsm@gmail.com
     *     time   : 18-12-18
     *     desc   : 请求转换类
     * </pre>
     */
    abstract class ConverterCallback<T> implements Callback<PrisonResponse<T>> {
        @Override
        public void onResponse(Call<PrisonResponse<T>> call, Response<PrisonResponse<T>> response) {
            try {
                PrisonResponse<T> dataResponse = response.body();

                if (dataResponse == null) {
                    throw new Exception(" 解析数据失败, 请联系管理员处理: " + "["+ response.code() + " - " + response.message() + "]");
                }

                // 判断是否请求成功
                if (dataResponse.code == 200) {
                    onSuccess(dataResponse.obj);
                } else {
                    String msg = dataResponse.msg == null ? "未知错误信息" : dataResponse.msg;
                    throw new Exception(msg + " [ " + dataResponse.code + " - " + dataResponse.errCode + " ]");
                }
            } catch (Exception e) {
                onError(e.getMessage());
            }
        }

        @Override
        public void onFailure(Call<PrisonResponse<T>> call, Throwable t) {
            t.printStackTrace();
            onError(t.getMessage());
        }

        abstract void onSuccess(@Nullable T t);

        abstract void onError(String err);
    }

}
