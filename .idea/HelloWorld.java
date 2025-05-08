import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelloWorld {
    private static Point mouseOffset;

    public static void main(String[] args) {
        // Создаем и настраиваем окно
        JFrame frame = new JFrame("Результаты программы");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        
        // Включаем поддержку прозрачности
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        
        // Создаем панель с эффектом матового стекла
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                
                Color darkGlass = new Color(30, 30, 30, 150);
                g2d.setColor(darkGlass);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
            }
        };
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setOpaque(false);

        // Панель управления в стиле macOS
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        controlPanel.setOpaque(false);
        
        // Создаем кнопки в стиле macOS
        JButton closeButton = createMacButton(new Color(255, 95, 87));
        JButton minimizeButton = createMacButton(new Color(255, 189, 46));
        JButton zoomButton = createMacButton(new Color(39, 201, 63));
        
        // Добавляем обработчики событий
        closeButton.addActionListener(e -> System.exit(0));
        minimizeButton.addActionListener(e -> frame.setState(Frame.ICONIFIED));
        zoomButton.addActionListener(e -> {
            if (frame.getExtendedState() == Frame.MAXIMIZED_BOTH) {
                frame.setExtendedState(Frame.NORMAL);
            } else {
                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            }
        });
        
        // Добавляем кнопки на панель
        controlPanel.add(closeButton);
        controlPanel.add(minimizeButton);
        controlPanel.add(zoomButton);
        
        // Центральная панель с текстом
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        
        // Создаем метки для вывода текста
        JLabel label1 = new JLabel("Лиза обними меня и пошли пить чай");
        JLabel label2 = new JLabel("Я изучаю Java версии 17");
        
        // Пример простых вычислений
        int a = 5;
        int b = 3;
        int sum = a + b;
        JLabel label3 = new JLabel(a + " + " + b + " = " + sum);
        
        // Настраиваем шрифт и стиль
        Font mainFont = new Font("SF Pro Display", Font.PLAIN, 24);
        Font secondaryFont = new Font("SF Pro Text", Font.PLAIN, 18);
        
        label1.setFont(mainFont);
        label2.setFont(secondaryFont);
        label3.setFont(secondaryFont);
        
        Color textColor = new Color(240, 240, 240);
        label1.setForeground(textColor);
        label2.setForeground(textColor);
        label3.setForeground(textColor);
        
        // Центрируем текст
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label3.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Добавляем отступы между элементами
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(label1);
        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(label2);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(label3);
        centerPanel.add(Box.createVerticalGlue());
        
        // Добавляем возможность перетаскивания окна
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseOffset = e.getPoint();
            }
        });
        
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (mouseOffset != null) {
                    Point newLocation = e.getLocationOnScreen();
                    newLocation.translate(-mouseOffset.x, -mouseOffset.y);
                    frame.setLocation(newLocation);
                }
            }
        });
        
        // Добавляем компоненты на основную панель
        panel.add(controlPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    private static JButton createMacButton(Color color) {
        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Рисуем круглую кнопку
                g2d.setColor(color);
                g2d.fillOval(0, 0, getWidth(), getHeight());
                
                // Добавляем эффект при наведении
                if (getModel().isRollover()) {
                    g2d.setColor(new Color(0, 0, 0, 30));
                    g2d.fillOval(0, 0, getWidth(), getHeight());
                }
            }
        };
        
        button.setPreferredSize(new Dimension(12, 12));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        return button;
    }
} 