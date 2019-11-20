package jakedilim.edu.com.baiduasrdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.baidu.aip.asrwakeup3.core.mini.ActivityMiniRecog;
import com.baidu.aip.asrwakeup3.core.mini.ActivityMiniUnit;
import com.baidu.aip.asrwakeup3.core.mini.ActivityMiniWakeUp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author by lim
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Glide.with(this)
                .asBitmap()
                .load(R.drawable.ic_launcher_background)
//                .override(200, 200)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.mipmap.ic_launcher)
                .thumbnail(1f)
                .centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }

    @OnClick({R.id.button, R.id.button2, R.id.button3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                startActivity(ActivityMiniWakeUp.class);
                break;
            case R.id.button2:
                startActivity(ActivityMiniRecog.class);
                break;
            case R.id.button3:
                startActivity(ActivityMiniUnit.class);
                break;
        }
    }

    protected void startActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

}
