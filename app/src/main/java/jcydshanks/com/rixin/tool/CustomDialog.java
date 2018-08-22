package jcydshanks.com.rixin.tool;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.text.Spanned;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import jcydshanks.com.rixin.Global;
import jcydshanks.com.rixin.R;

/**
 * Created by JcyDS on 2018/8/6.
 */

public class CustomDialog {
    private Context mContext;

    private TextView titleText;

    private TextView messageText;

    private TextView customdialog_other;

    private CheckBox checkBox;

    private TextView customdialog_sure;

    private TextView customdialog_no;

    /**
     * 按键监听事件
     */
    private OnCustomDialogClickListener onCustomDialogClickListener;

    /**
     * 自定义布局的父布局
     */
    private LinearLayout layout;
    /**
     * 悬浮框
     */
    private AlertDialog alertDialog;

    /**
     * 悬浮框布局
     */
    private View dialogView;

    /**
     * 是否显示确定按钮
     */
    private boolean isShowTrue = true;

    /**
     * 是否显示取消按钮
     */
    private boolean isShowFalse = true;

    private boolean isShowOther = true;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * 构造方法
     * @param mContext
     */
    public CustomDialog(Context mContext) {
        this.mContext = mContext;
        initView();
    }


    /**
     * 点击方法监听
     */
    public interface OnCustomDialogClickListener {
        //点击确定
        public void onTrueClick(CustomDialog dialog);

        //点击取消
        public void onFlaseClick(CustomDialog dialog);

        //点击其他
        public void onOrherClick(CustomDialog dialog);
    }
    /**
     * 实例化组件
     */
    private void initView(){
        dialogView = LayoutInflater.from(mContext).inflate(R.layout.custom_dialog, null);
        titleText = dialogView.findViewById(R.id.dialog_title);
        messageText = (TextView) dialogView.findViewById(R.id.check_meaasge);
        checkBox = (CheckBox) dialogView.findViewById(R.id.check);
        checkBox.setChecked(Global.check);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Global.check = isChecked;
            }
        });
        customdialog_other = dialogView.findViewById(R.id.customdialog_other);
        customdialog_sure = (TextView) dialogView.findViewById(R.id.customdialog_sure);
        customdialog_no = (TextView) dialogView.findViewById(R.id.customdialog_no);
        layout = (LinearLayout) dialogView.findViewById(R.id.check_layout);
        customdialog_sure.setOnClickListener(onClickListener);
        customdialog_no.setOnClickListener(onClickListener);
        customdialog_other.setOnClickListener(onClickListener);
        alertDialog = new AlertDialog.Builder(mContext,R.style.Theme_Transparent).create();
        alertDialog.setIcon(R.color.write);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setView(dialogView, -1, -1, 0, -1);
    }
    /**
     * 设置窗口属性
     * @param type
     */
    public void setWindowsType(int type) {
        alertDialog.getWindow().setType(type);
    }
    /**
     * 设置是否显示确定按钮
     * @param isShowTrue
     */
    public void showTrue(boolean isShowTrue) {
        this.isShowTrue = isShowTrue;
    }

    /**
     * 设置是否显示取消按钮
     * @param isShowFalse
     */
    public void showFalse(boolean isShowFalse) {
        this.isShowFalse = isShowFalse;
    }

    public void showOther(boolean isShowOther) {
        this.isShowOther = isShowOther;
    }


    /**
     * 设置按键监听方法
     * @param onCustomDialogClickListener
     */
    public void setOnCustomDialogClickListener(OnCustomDialogClickListener onCustomDialogClickListener) {
        this.onCustomDialogClickListener = onCustomDialogClickListener;
    }

    /**
     * 移除监听
     */
    public void removeOnCustomDialogClickListener() {
        this.onCustomDialogClickListener = null;
    }


    /**
     * 设置自定义布局
     * @param view
     */
    public void setView(View view) {
        layout.addView(view);
    }

    public void setCheck(int v){
        checkBox.setVisibility(v);
    }

    /**
     * 显示对话框
     */
    public void show() {

        if (!isShowTrue) {
            customdialog_sure.setVisibility(View.GONE);
        }
        if (!isShowFalse) {
            customdialog_no.setVisibility(View.GONE);
        }
        if (!isShowOther) {
            customdialog_other.setVisibility(View.GONE);
        }
        alertDialog.show();
    }
    /**
     * 是否能被返回键消失
     * @param isCancel
     */
    public void setCancel(boolean isCancel) {
        alertDialog.setCancelable(isCancel);
    }

    /**
     * 将对话框消失
     */
    public void dismiss() {
        alertDialog.cancel();
    }

    /**
     * 设置标题文字
     * @param title
     */
    public void setTitle(String title) {
        titleText.setText(title);
    }

    public void setVisible(int v){
        titleText.setVisibility(v);
    }

    /**
     *设置显示的文字
     */
    public void setMessage(String message) {
        messageText.setText(message);
    }

    public void setMessage_Html(Spanned paramSpanned) {
        messageText.setText(paramSpanned);
    }

    /**
     * 设置文字
     * 设置文字颜色
     * 设置按钮背景颜色
     */

    public void setOtherBackgroundColor(int color){
        customdialog_other.setBackgroundColor(color);
    }
    public void setFalseBackgroundColor(int color){
        customdialog_no.setBackgroundColor(color);
    }
    public void setTrueBackgroundColor(int color){
        customdialog_sure.setBackgroundColor(color);
    }
    public void setOtherTextColor(int color){
        customdialog_other.setTextColor(color);
    }

    public void setTrueTextColor(int color){
        customdialog_sure.setTextColor(color);
    }

    public void setFalseTextColor(int color){
        customdialog_no.setTextColor(color);
    }

    public void setTrueText(String text) {
        customdialog_sure.setText(text);
    }

    public void setGravity(int paramInt) {
        messageText.setGravity(paramInt);
    }

    public void setFalseText(String text) {
        customdialog_no.setText(text);
    }

    public void setOtherText(String text) {
        customdialog_other.setText(text);
    }

    /**
     * 点击方法监听
     */
    private OnClickListener onClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            try {
                switch (v.getId()) {
//                    case R.id.cancel:
//                        if (onCustomDialogClickListener != null) {
//                            onCustomDialogClickListener.onFlaseClick(CustomDialog.this);
//                        }
//                        break;
                    case R.id.customdialog_sure:
                        if (onCustomDialogClickListener != null) {
                            onCustomDialogClickListener.onTrueClick(CustomDialog.this);
                        }
                        break;
                    case R.id.customdialog_no:
                        if (onCustomDialogClickListener != null) {
                            onCustomDialogClickListener.onFlaseClick(CustomDialog.this);
                        }
                        break;
                    case R.id.customdialog_other:
                        if (onCustomDialogClickListener != null) {
                            onCustomDialogClickListener.onOrherClick(CustomDialog.this);
                        }
                        break;
                    default:
                        break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };



}