package stackOverflow.formProg1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class formProg1 {
	File pathDir = null;
	String[] pathsFilesAndDir;
	static int n = 0;

	formProg1(){
		JFrame jfrm1 = new JFrame("Каталог");
		jfrm1.setSize(400, 400);
		jfrm1.setLayout(null);
		jfrm1.setVisible(true);
		jfrm1.setResizable(false);
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton jbtn1 = new JButton("Enter");
		jbtn1.setBounds(150, 320, 100, 30);
		jfrm1.add(jbtn1);

		DefaultListModel<String> list = new DefaultListModel< >();
		JList<String> b = new JList< >(list);
		b.setBounds(0,0,380,300);
		b.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jfrm1.add(b);

		JScrollPane jsp1 = new JScrollPane();
		jsp1.setBounds(0, 0, 400, 300 );
		jsp1.setViewportView(b);
		jfrm1.add(jsp1);

		JLabel jl = new JLabel();
		jl.setBounds(10,320,100,20);

		jfrm1.add(jl);

		// Создание нового объекта file
		pathDir = new File("/home/atlas/"); // Обязательно должен существовать указанный каталог на диске, иначе программа выдаст ошибку
		// Массив файлов и папок
		pathsFilesAndDir = pathDir.list();

		//События
		jbtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 3; i++)
				{
					if (n < pathsFilesAndDir.length) {
						// Вывод списка файлов и каталогов
						list.addElement(("№" + n) + " " + pathsFilesAndDir[n]);
						n++;
					}
				}
			}
		});
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						new formProg1();
//						new DefaultListModel();
//						new JScrollPane();
					}
				}
		);
	}
}