package com.raven.swing;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelTransparent extends JPanel {

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }

    private float alpha = 1f;

    public PanelTransparent() {
        setOpaque(false);
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paint(grphcs);
    }
}
