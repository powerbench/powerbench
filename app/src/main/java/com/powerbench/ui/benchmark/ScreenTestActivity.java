package com.powerbench.ui.benchmark;

import android.os.Bundle;

import com.powerbench.R;
import com.powerbench.benchmarks.BrightnessBenchmark;
import com.powerbench.constants.BenchmarkConstants;
import com.powerbench.model.ModelManager;

/**
 * The activity that runs the screen test to generate the model for the screen brightness.
 */
public class ScreenTestActivity extends BenchmarkActivity {

    /**
     * The brighness benchmark.
     */
    private BrightnessBenchmark mBrightnessBenchmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benchmark);
        initialize();
        getSupportActionBar().setTitle(getString(R.string.screen_test));
        mBrightnessBenchmark = new BrightnessBenchmark(this, BenchmarkConstants.BRIGHTNESS_DURATION_STEP, BenchmarkConstants.BRIGHTNESS_STEP);
        startBenchmark(mBrightnessBenchmark);
    }

    @Override
    protected void showBenchmarkResults() {
        if (mBrightnessBenchmark != null) {
            ModelManager.getInstance().setScreenModel(this, mBrightnessBenchmark.getModel());
        }
        finish();
    }
}
