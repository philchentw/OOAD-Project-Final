package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

import constant.Constant;
import controller.EditController;
import mode.BaseMode;

public class ToolBar extends JPanel {
	private ArrayList<JButton> buttons = new ArrayList<>();
	
	public ToolBar() {
		setBackground(Color.gray);
		setPreferredSize(new Dimension(Constant.TOOLBAR_WIDTH, Constant.TOOLBAR_HEIGHT));
		setVisible(true);
		setLayout(new GridLayout(7, 1));
		
		// 建立按鈕
        buttons.add(createButton("image/cursor.png", () -> {
            EditController.getInstance().currentMode =
                EditController.getInstance().selectMode;
        }));

        buttons.add(createButton("image/association.png", () -> {
            EditController.getInstance().currentMode =
                EditController.getInstance().associationMode;
        }));

        buttons.add(createButton("image/generalization_line.png", () -> {
            EditController.getInstance().currentMode =
                EditController.getInstance().generalizationLineMode;
        }));

        buttons.add(createButton("image/com_line_nobg.png", () -> {
            EditController.getInstance().currentMode =
                EditController.getInstance().compositionLineMode;
        }));

        buttons.add(createButton("image/dependency2.png", () -> {
            EditController.getInstance().currentMode =
                EditController.getInstance().dependencyLineMode;
        }));

        buttons.add(createButton("image/class_nobg.png", () -> {
            EditController.getInstance().currentMode =
                EditController.getInstance().classMode;
        }));

        buttons.add(createButton("image/case_nobg.png", () -> {
            EditController.getInstance().currentMode =
                EditController.getInstance().useCaseMode;
        }));
		
		for (JButton button : buttons) {
			add(button);
		}
		
		setVisible(true);
	}
	
	// 建立按鈕的共用方法
    private JButton createButton(String iconPath, Runnable onClick) {
        JButton button = new JButton(new ImageIcon(iconPath));

        button.setFocusPainted(false);

        button.addActionListener(e -> {
            initializeIcon(); // reset其他按鈕

            button.setOpaque(true);
            button.setBackground(Color.LIGHT_GRAY);

            onClick.run(); // 執行 mode 切換
        });

        return button;
    }
    
	public void initializeIcon() {
		for (JButton button : buttons) {
			button.setBackground(UIManager.getColor("Button.background"));
			button.setOpaque(false);
		}
	}
}
