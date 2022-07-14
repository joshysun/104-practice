package com.josh.practice.designPattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TextModel implements Prototype<TextModel> {
    private Font font;
    private String text;
    private String alignment;
    private int color;
    private int background;
    private String style;

    @Override
    public TextModel copy() {
        return new TextModel(font.copy(), text, alignment, color, background, style);
    }
}
