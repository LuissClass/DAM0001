package juegos.colorsToText;

// ==== CODIGO GENERADO POR CHATGPT ====
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.*;

public class ColorSwatches {

    // Método para mostrar la ventana con los colores que le pasas
    public static void showWithColors(String colorString) {
        SwingUtilities.invokeLater(() -> createAndShowGui(colorString));
    }

    private static void createAndShowGui(String initialColors) {
        JFrame frame = new JFrame("Color Swatches");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel top = new JPanel(new BorderLayout(6, 6));
        JTextField input = new JTextField(initialColors != null ? initialColors : "");
        JButton renderBtn = new JButton("Render");

        top.add(new JLabel("Cadena de colores:"), BorderLayout.WEST);
        top.add(input, BorderLayout.CENTER);
        top.add(renderBtn, BorderLayout.EAST);

        content.add(top, BorderLayout.NORTH);

        JPanel swatchesPanel = new JPanel();
        swatchesPanel.setLayout(new WrapLayout(FlowLayout.LEFT, 10, 10));
        JScrollPane scroll = new JScrollPane(swatchesPanel);
        content.add(scroll, BorderLayout.CENTER);

        renderBtn.addActionListener(e -> renderColors(input.getText(), swatchesPanel, frame));
        input.addActionListener(e -> renderBtn.doClick());

        // Render inicial
        renderColors(initialColors, swatchesPanel, frame);

        frame.setContentPane(content);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void renderColors(String text, JPanel container, Component parent) {
        container.removeAll();

        ArrayList<String> codes = extractHexCodes(text);
        if (codes.isEmpty()) {
            JOptionPane.showMessageDialog(parent,
                    "No se encontraron colores válidos. Usa formatos como #RRGGBB o #RGB.\nEjemplo: #000033#D70972#C25BA5",
                    "Sin colores", JOptionPane.INFORMATION_MESSAGE);
            container.revalidate();
            container.repaint();
            return;
        }

        for (String hex : codes) {
            JPanel sw = createSwatch(hex);
            container.add(sw);
        }

        container.revalidate();
        container.repaint();
    }

    private static JPanel createSwatch(String hex) {
        Color color = parseHexColor(hex);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(120, 120));
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JPanel colorBox = new JPanel();
        colorBox.setBackground(color);
        colorBox.setPreferredSize(new Dimension(120, 80));
        panel.add(colorBox, BorderLayout.CENTER);

        JLabel label = new JLabel(hex.toUpperCase(), SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(6, 0, 6, 0));
        label.setForeground(getReadableTextColor(color));
        panel.add(label, BorderLayout.SOUTH);

        panel.setToolTipText("Click para copiar " + hex.toUpperCase());
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                copyToClipboard(hex.toUpperCase());
                //JOptionPane.showMessageDialog(panel, hex.toUpperCase() + " copiado al portapapeles",
                //        "Copiado", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        return panel;
    }

    private static void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    private static ArrayList<String> extractHexCodes(String text) {
        ArrayList<String> result = new ArrayList<>();
        if (text == null) return result;

        Pattern p = Pattern.compile("#([0-9A-Fa-f]{6}|[0-9A-Fa-f]{3})");
        Matcher m = p.matcher(text);
        while (m.find()) {
            String raw = m.group(0);
            String expanded = expandIfShort(raw);
            result.add(expanded);
        }
        return result;
    }

    private static String expandIfShort(String hex) {
        if (hex.length() == 4) {
            char r = hex.charAt(1);
            char g = hex.charAt(2);
            char b = hex.charAt(3);
            return "#" + r + r + g + g + b + b;
        }
        return hex;
    }

    private static Color parseHexColor(String hex) {
        return Color.decode(hex);
    }

    private static Color getReadableTextColor(Color bg) {
        double r = bg.getRed() / 255.0;
        double g = bg.getGreen() / 255.0;
        double b = bg.getBlue() / 255.0;
        double lum = 0.2126 * r + 0.7152 * g + 0.0722 * b;
        //return lum > 0.6 ? Color.BLACK : Color.WHITE;
        return Color.BLACK;
    }

    static class WrapLayout extends FlowLayout {
        public WrapLayout(int align, int hgap, int vgap) {
            super(align, hgap, vgap);
        }

        @Override
        public Dimension preferredLayoutSize(Container target) {
            return layoutSize(target, true);
        }

        @Override
        public Dimension minimumLayoutSize(Container target) {
            Dimension minimum = layoutSize(target, false);
            minimum.width -= (getHgap() + 1);
            return minimum;
        }

        private Dimension layoutSize(Container target, boolean preferred) {
            synchronized (target.getTreeLock()) {
                int targetWidth = target.getWidth();
                if (targetWidth == 0) targetWidth = Integer.MAX_VALUE;

                int hgap = getHgap();
                int vgap = getVgap();
                Insets insets = target.getInsets();
                int maxWidth = targetWidth - (insets.left + insets.right + hgap * 2);

                int x = 0, y = insets.top + vgap;
                int rowHeight = 0;
                int nmembers = target.getComponentCount();

                for (int i = 0; i < nmembers; i++) {
                    Component m = target.getComponent(i);
                    if (!m.isVisible()) continue;
                    Dimension d = preferred ? m.getPreferredSize() : m.getMinimumSize();
                    if (x == 0 || (x + d.width) <= maxWidth) {
                        if (x > 0) x += hgap;
                        x += d.width;
                        rowHeight = Math.max(rowHeight, d.height);
                    } else {
                        x = d.width;
                        y += vgap + rowHeight;
                        rowHeight = d.height;
                    }
                }
                y += rowHeight + insets.bottom;
                return new Dimension(targetWidth, y);
            }
        }
    }
}
