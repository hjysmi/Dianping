package com.alipay.sdk.app;

import com.alipay.sdk.util.FileDownloader;
import com.alipay.sdk.widget.SystemDefaultDialog;

class PayTask$4
  implements Runnable
{
  public void run()
  {
    if (PayTask.b(this.a) != null)
      PayTask.b(this.a).c();
    SystemDefaultDialog.a(PayTask.a(this.a), "提示", "下载安装包失败，是否重试？", "重试", new PayTask.4.1(this), "取消", new PayTask.4.2(this));
  }
}

/* Location:           C:\Users\xuetong\Desktop\dazhongdianping7.9.6\ProjectSrc\classes-dex2jar.jar
 * Qualified Name:     com.alipay.sdk.app.PayTask.4
 * JD-Core Version:    0.6.0
 */