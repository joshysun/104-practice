package com.josh.practice.designPattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Font implements Prototype<Font> {
    private Typeface typeface;
    private String fontName;

    @Override
    public Font copy() {
        return new Font(typeface.copy(), fontName);
    }
}
