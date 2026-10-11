package com.example.headshotpanel;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Switch;

public class MainActivity extends Activity {

    private int red = Color.rgb(255, 35, 65);
    private int black = Color.rgb(12, 12, 18);
    private TextView status;

    private TextView makeText(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setGravity(Gravity.CENTER);
        t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(24, 30, 24, 30);
        root.setBackgroundColor(black);

        TextView title = makeText(
                "⚡ HEADSHOT PANEL ⚡", 25, red);
        root.addView(title);

        TextView subtitle = makeText(
                "GAMING DEMO INTERFACE", 12, Color.WHITE);

        LinearLayout.LayoutParams p =
                new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 15, 0, 30);
        root.addView(subtitle, p);

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setGravity(Gravity.CENTER);
        card.setPadding(20, 25, 20, 25);
        card.setBackgroundColor(Color.rgb(30, 30, 42));

        root.addView(card, new LinearLayout.LayoutParams(-1, -2));

        TextView feature = makeText(
                "🎯 AUTO HEADSHOT", 21, Color.WHITE);
        card.addView(feature);

        TextView description = makeText(
                "DEMO MODE ONLY", 12, Color.LTGRAY);
        p = new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 12, 0, 20);
        card.addView(description, p);

        Switch demoSwitch = new Switch(this);
        demoSwitch.setText("Enable Demo");
        demoSwitch.setTextColor(Color.WHITE);
        card.addView(demoSwitch);

        status = makeText("● STATUS: OFF", 17, Color.GRAY);
        p = new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 25, 0, 0);
        card.addView(status, p);

        demoSwitch.setOnCheckedChangeListener((button, checked) -> {
            AlphaAnimation anim = new AlphaAnimation(0.3f, 1f);
            anim.setDuration(350);
            status.startAnimation(anim);

            if (checked) {
                status.setText("● STATUS: DEMO ON");
                status.setTextColor(Color.GREEN);
            } else {
                status.setText("● STATUS: OFF");
                status.setTextColor(Color.GRAY);
            }
        });

        TextView footer = makeText(
                "ANDROID GAMING UI\nDEMO • NOT CONNECTED TO ANY GAME",
                11, Color.LTGRAY);

        p = new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(0, 25, 0, 0);
        root.addView(footer, p);

        setContentView(root);
    }
}
