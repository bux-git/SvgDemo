package com.example.lym.svgdemo;

import android.content.Context;
import android.graphics.Typeface;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Description：
 * @author：Bux on 2017/12/26 20:10
 * @email: 471025316@qq.com
 */

public class CFont implements ITypeface {
    private static final String TTF_FILE = "bux_play-font-v1.ttf";
    private static Typeface typeface = null;
    private static HashMap<String, Character> mChars;

    @Override
    public IIcon getIcon(String key) {
        return Icon.valueOf(key);
    }

    @Override
    public HashMap<String, Character> getCharacters() {
        if (mChars == null) {
            HashMap<String, Character> aChars = new HashMap<String, Character>();
            for (Icon v : Icon.values()) {
                aChars.put(v.name(), v.character);
            }
            mChars = aChars;
        }
        return mChars;
    }

    @Override
    public String getMappingPrefix() {
        return "bux";
    }

    @Override
    public String getFontName() {
        return "bux play";
    }

    @Override
    public String getVersion() {
        return "1";
    }

    @Override
    public int getIconCount() {
        return mChars.size();
    }

    @Override
    public Collection<String> getIcons() {
        Collection<String> icons = new LinkedList<String>();
        for (Icon value : Icon.values()) {
            icons.add(value.name());
        }
        return icons;
    }

    @Override
    public String getAuthor() {
        return "bux";
    }

    @Override
    public String getUrl() {
        return "https://github.com/bux-git";
    }

    @Override
    public String getDescription() {
        return "https://github.com/bux-git";
    }

    @Override
    public String getLicense() {
        return "https://github.com/bux-git";
    }

    @Override
    public String getLicenseUrl() {
        return "https://github.com/bux-git";
    }

    @Override
    public Typeface getTypeface(Context context) {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + TTF_FILE);
            } catch (Exception e) {
                return null;
            }
        }
        return typeface;
    }

    public enum Icon implements IIcon {
        bux_ttpodicon('\ue66e'),
        bux_icon('\ue652'),
        bux_tuijian('\ue600'),
        bux_youxi('\ue602');

        char character;

        Icon(char character) {
            this.character = character;
        }

        @Override
        public String getFormattedName() {
            return "{" + name() + "}";
        }

        @Override
        public char getCharacter() {
            return character;
        }

        @Override
        public String getName() {
            return name();
        }

        // remember the typeface so we can use it later
        private static ITypeface typeface;

        @Override
        public ITypeface getTypeface() {
            if (typeface == null) {
                typeface = new CFont();
            }
            return typeface;
        }
    }
}
