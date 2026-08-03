package ui;

import service.Library;
import model.Book;
import model.StudentMember;
import model.FacultyMember;

import javax.swing.*;
import java.awt.*;

public class LibraryGUI {
    private final Library library = new Library();

    public void startGUI() {
        
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(450, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        frame.setLayout(new GridLayout(6, 1, 10, 10));

        JLabel titleLabel = new JLabel("--- LIBRARY MANAGEMENT SYSTEM ---", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(titleLabel);
        JButton btnAddBook = new JButton("1. Add Book");
        JButton btnAddMember = new JButton("2. Register Member");
        JButton btnIssueBook = new JButton("3. Issue Book");
        JButton btnReturnBook = new JButton("4. Return Book");
        JButton btnExit = new JButton("5. Exit");
        btnAddBook.addActionListener(e -> {
            String bId = JOptionPane.showInputDialog(frame, "Enter Book ID:");
            String title = JOptionPane.showInputDialog(frame, "Enter Title:");
            if (bId != null && title != null && !bId.isEmpty() && !title.isEmpty()) {
                library.addBook(new Book(bId, title));
                JOptionPane.showMessageDialog(frame, "Book Added Successfully!");
            }
        });

        btnAddMember.addActionListener(e -> {
            String mId = JOptionPane.showInputDialog(frame, "Enter Member ID:");
            String name = JOptionPane.showInputDialog(frame, "Enter Name:");
            String[] options = {"Student", "Faculty"};
            int type = JOptionPane.showOptionDialog(frame, "Select Member Type:", "Member Type",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (mId != null && name != null && type != -1) {
                if (type == 0) library.addMember(new StudentMember(mId, name));
                else library.addMember(new FacultyMember(mId, name));
                JOptionPane.showMessageDialog(frame, "Member Registered Successfully!");
            }
        });

        btnIssueBook.addActionListener(e -> {
            String bId = JOptionPane.showInputDialog(frame, "Enter Book ID:");
            String mId = JOptionPane.showInputDialog(frame, "Enter Member ID:");
            if (bId != null && mId != null) {
                library.issueBook(bId, mId);
                JOptionPane.showMessageDialog(frame, "Process Complete! Check Console/Status.");
            }
        });

        btnReturnBook.addActionListener(e -> {
            String bId = JOptionPane.showInputDialog(frame, "Enter Book ID:");
            if (bId != null) {
                library.returnBook(bId);
                JOptionPane.showMessageDialog(frame, "Process Complete! Check Console/Status.");
            }
        });

        btnExit.addActionListener(e -> System.exit(0));

       
        frame.add(btnAddBook);
        frame.add(btnAddMember);
        frame.add(btnIssueBook);
        frame.add(btnReturnBook);
        frame.add(btnExit);
        frame.setVisible(true);
    }
}