package com.jvms.i18neditor.editor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;

/**
 * This class represents a status icon for a translation tree cell.
 * 
 * @author Jacob
 */
public class TranslationTreeStatusIcon implements Icon {
    private final static int SIZE = 7;
    private final Type type;
    
	public enum Type {
    	Warning(new Color(220,160,0));
    	
    	private Color color;
    	
    	public Color getColor() {
    		return color;
    	}
    	
    	private Type(Color color) {
    		this.color = color;
    	}
    }
    
    public TranslationTreeStatusIcon(Type type) {
        this.type = type;
    }
    
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
    	Graphics2D g2 = (Graphics2D) g.create();
	    g2.setRenderingHints(new RenderingHints(
	    		RenderingHints.KEY_ANTIALIASING,
    	        RenderingHints.VALUE_ANTIALIAS_ON));
		g2.setColor(type.getColor());
    	g2.fillOval(x, y, SIZE, SIZE);
    	g2.dispose();
    }
    
    @Override
    public int getIconWidth() {
        return SIZE;
    }
    
    @Override
    public int getIconHeight() {
        return SIZE;
    }
}