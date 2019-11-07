package wangdaye.com.geometricweather.main.ui.adapter.main.holder;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import java.util.List;

import wangdaye.com.geometricweather.R;
import wangdaye.com.geometricweather.basic.model.location.Location;
import wangdaye.com.geometricweather.main.ui.MainColorPicker;
import wangdaye.com.geometricweather.resource.provider.ResourceProvider;

public class FooterViewHolder extends AbstractMainViewHolder {

    private TextView text;

    public FooterViewHolder(@NonNull Activity activity, ViewGroup parent,
                            @NonNull ResourceProvider provider, @NonNull MainColorPicker picker,
                            @Px float cardMarginsVertical, @Px float cardMarginsHorizontal,
                            @Px float cardRadius, @Px float cardElevation) {
        super(activity, LayoutInflater.from(activity).inflate(R.layout.container_main_footer, parent, false),
                provider, picker, cardMarginsVertical, cardMarginsHorizontal, cardRadius, cardElevation, false);

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) itemView.getLayoutParams();
        if (cardMarginsVertical == 0) {
            int marginsVertical = activity.getResources().getDimensionPixelSize(R.dimen.little_margin);
            params.setMargins(0, marginsVertical, 0, marginsVertical);
        } else {
            params.setMargins(0, 0, 0, (int) cardMarginsVertical);
        }
        itemView.setLayoutParams(params);

        this.text = itemView.findViewById(R.id.container_main_footer_title);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindView(@NonNull Location location) {
        text.setText("Powered by " + location.getWeatherSource().getSourceUrl());
    }

    @Override
    protected Animator getEnterAnimator(List<Animator> pendingAnimatorList) {
        Animator a = ObjectAnimator.ofFloat(itemView, "alpha", 0f, 1f);
        a.setDuration(450);
        a.setInterpolator(new FastOutSlowInInterpolator());
        a.setStartDelay(pendingAnimatorList.size() * 150);
        return a;
    }
}