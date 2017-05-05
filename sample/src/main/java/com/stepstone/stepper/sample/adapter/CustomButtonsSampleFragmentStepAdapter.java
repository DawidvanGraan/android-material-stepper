package com.stepstone.stepper.sample.adapter;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.sample.R;
import com.stepstone.stepper.sample.step.fragment.StepFragmentSample;
import com.stepstone.stepper.viewmodel.StepViewModel;

public class CustomButtonsSampleFragmentStepAdapter extends AbstractFragmentStepAdapter {

    public CustomButtonsSampleFragmentStepAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        switch (position) {
            case 0:
                return StepFragmentSample.newInstance(R.layout.fragment_step);
            case 1:
                return StepFragmentSample.newInstance(R.layout.fragment_step2);
            case 2:
                return StepFragmentSample.newInstance(R.layout.fragment_step3);
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public int getStepCount() {
        return 3;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
        StepViewModel.Builder builder = new StepViewModel.Builder(context)
                .setTitle(R.string.tab_title);
        switch (position) {
            case 0:
                builder
                        .setNextButtonLabel("This way")
                        .setBackButtonLabel("Cancel")
                        .setNextButtonEndDrawableResId(R.drawable.ms_forward_arrow)
                        .setBackButtonStartDrawableResId(StepViewModel.NULL_DRAWABLE);
                break;
            case 1:
                builder
                        .setNextButtonLabel(R.string.go_to_summary)
                        .setBackButtonLabel("Go to first")
                        .setBackButtonStartDrawableResId(R.drawable.ms_back_arrow);
                break;
            case 2:
                builder.setBackButtonLabel("Go back");
                break;
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }
        return builder.create();
    }

}