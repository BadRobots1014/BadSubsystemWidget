/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartdashboard.extensions;

import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.gui.elements.Subsystem;
import edu.wpi.first.smartdashboard.gui.elements.bindings.AbstractTableWidget;
import edu.wpi.first.smartdashboard.gui.elements.bindings.NumberBindable;
import edu.wpi.first.smartdashboard.gui.elements.bindings.StringBindable;
import edu.wpi.first.smartdashboard.livewindow.elements.NameTag;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import edu.wpi.first.smartdashboard.types.named.SubsystemType;
import edu.wpi.first.wpilibj.networking.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.client.NetworkTableClient;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * @author Jon Buckley
 */
/*
public class BadSubsystemWidget extends AbstractTableWidget
{
    public static final DataType[] TYPES = { SubsystemType.get()};
    Dimension preferredDimension = new Dimension(100,100);
    Color color = Color.CYAN;
    

    JTextField test;
    private JButton button;
    
    public BadSubsystemWidget()
    {
        super();
        this.setPreferredSize(preferredDimension);
        
    }

    @Override
    public void propertyChanged(Property prprt)
    {
        
    }
    
    

    @Override
    public void init()
    {
        test = new NumberTableField("MAX_POWER");
        
        test.setColumns(10);
        
        //test.setText((table == null) + "");
        
        //table.putNumber("MAX_POWER", .2);

        button = new JButton("Press me!");
        /*button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                test.setText((table == null) + "");
                
                //table.putNumber("MAX_POWER", new Double(test.getText()));
            }
            
        });
        
        add(test);  
        add(button);
        
       //this.setNumberBinding("MAX_POWER", test);
         
        revalidate();
        repaint();
        
    }
    @Override
    public void valueChanged(ITable itable, String string, Object o, boolean bln)
    {
        test.setText("1");
        revalidate();
        repaint();
    }
}*/

public class BadSubsystemWidget extends AbstractTableWidget 
{
    private SubsystemNumberField field;
    
    public static final DataType[] TYPES = { SubsystemType.get() };
    
    public BadSubsystemWidget()
    {
        NumberBindable bind;
        BindableNumberField value;
        field = new SubsystemNumberField();
        field.setColumns(10);
        
        add(field);
        add(nameTag = new NameTag(""));
                
        revalidate();
        repaint();

    }

    @Override
    public void init()
    {
        nameTag.setText(getFieldName());
    }

    @Override
    public void propertyChanged(Property prprt)
    {
        
    }

    private class SubsystemNumberField extends BindableNumberField
    {
        public SubsystemNumberField()
        {
            super(NumberBindable.NULL);
            setNumberBinding("MAX_POWER", new NumberBindable(){

            @Override
                    public void setBindableValue(double value) {
                            SubsystemNumberField.this.setBindableValue(value);
                    }
                }
            );
        }
    }
}


/*
public class BadSubsystemWidget extends Widget implements ITableListener
{
    public static final DataType[] TYPES = { SubsystemType.get(), DataType.TABLE};
    ITable table;
    JTextField field;

    public BadSubsystemWidget()
    {
         
        field = new JTextField("--");
        field.setColumns(10);
        this.add(field);
    }
    
    @Override
    public void setValue(Object o)
    {
        if (table != null)
            table.removeTableListener(this);
        
        table = (ITable) o;
        table.addTableListener(this);
        
        field.setText("setting value");
        revalidate();
        repaint();
    }

    @Override
    public void init()
    {
        this.setPreferredSize(new Dimension(100,100));
       
    }

    @Override
    public void propertyChanged(Property prprt)
    {
    }

    @Override
    public void valueChanged(ITable itable, String string, Object o, boolean bln)
    {
        field.setText("val changed");
        revalidate();
        repaint();
    }
    
}*/