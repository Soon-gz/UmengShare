package com.abings.umengsharedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

public class MainActivity extends AppCompatActivity {
    private UMShareListener umShareListener;
    private UMImage image;
    private ShareAction action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        umShareListener = new UMShareListener() {
            @Override
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(MainActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA platform, Throwable t) {
                Toast.makeText(MainActivity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(MainActivity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
            }
        };
        image = new UMImage(this,"http://jy.sccnn.com/zb_users/upload/2013/9/2013092266047329.jpg");
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_qq:
                action = new ShareAction(this).setPlatform(SHARE_MEDIA.QQ).setCallback(umShareListener);
                action.withTargetUrl("http://http://blog.csdn.net/sw5131899");
                action.withText("分享 LegandSea:http://blog.csdn.net/sw5131899");
                action.withMedia(image);
                break;
            case R.id.btn_wx:
                action = new ShareAction(this).setPlatform(SHARE_MEDIA.WEIXIN).setCallback(umShareListener);
                action.withTargetUrl("http://http://blog.csdn.net/sw5131899");
                action.withMedia(image);
                break;
            case R.id.btn_wb:
                action = new ShareAction(this).setPlatform(SHARE_MEDIA.SINA).setCallback(umShareListener);
                action.withTargetUrl("http://http://blog.csdn.net/sw5131899");
                action.withText("分享 LegandSea:http://blog.csdn.net/sw5131899");
                action.withMedia(image);
                break;
            case R.id.btn_wxcircle:
                action = new ShareAction(this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE).setCallback(umShareListener);
                action.withTargetUrl("http://http://blog.csdn.net/sw5131899");
                action.withMedia(image);
                break;
        }
        action.share();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult( requestCode, resultCode, data);
    }
}
