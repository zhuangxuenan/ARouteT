package com.king.commonlib.base.mvvm.binding.viewadapter.radiogroup;


import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.king.commonlib.base.mvvm.binding.command.BindingCommand;

import androidx.annotation.IdRes;
import androidx.databinding.BindingAdapter;

/**
 * Created by goldze on 2017/6/18.
 */
public class ViewAdapter {
    @BindingAdapter(value = {"onCheckedChangedCommand"}, requireAll = false)
    public static void onCheckedChangedCommand(final RadioGroup radioGroup, final BindingCommand<String> bindingCommand) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                bindingCommand.execute(radioButton.getText().toString());
            }
        });
    }
}
