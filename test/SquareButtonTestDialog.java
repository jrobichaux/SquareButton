/*
 * This is a simple test of com.snapps.swt.SquareButton functionality.
 */


import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.snapps.swt.SquareButton;


public class SquareButtonTestDialog extends ApplicationWindow {
	private static String IMG1_PATH = "./icons/pinstripes.png";
	private static String IMG2_PATH = "./icons/tango-face-glasses.png";
	SquareButton inactiveButton;
	
	
	public static void main(String[] args) {
		ApplicationWindow window = new SquareButtonTestDialog(null);
		window.setBlockOnOpen(true);
		window.open();
	}
	
	
	public SquareButtonTestDialog(Shell arg0) {
		super(arg0);
	}
	
	
	protected Control createContents(Composite parent) {
		getShell().setText("com.snapps.swt.SquareButton Test");
		
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing = 12;
		layout.verticalSpacing = 8;
		composite.setLayout(layout);
		//composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
		
		
		// a button that toggles the inactive status of the second button
		SquareButton defaultButton = new SquareButton(composite, SWT.NONE);
		defaultButton.setText("Default button style");
		defaultButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				inactiveButton.setEnabled( !inactiveButton.getEnabled() );
			}
		});
		
		inactiveButton = new SquareButton(composite, SWT.NONE);
		inactiveButton.setEnabled(false);
		inactiveButton.setText("Inactive button");
		
		
		// a few examples of custom buttons (you can probably do better)
		SquareButton grayButton = getGrayButton(composite);
		grayButton.setText("Custom Gray Button");
		
		SquareButton customButton = getCustomButton(composite);
		customButton.setText("Another Custom Button");
		
		
		// a small background image that can be tiled
		Image image = new Image(getShell().getDisplay(), IMG1_PATH);
		SquareButton imageButton = new SquareButton(composite, SWT.NONE);
		imageButton.setText("Button With Cropped Image");
		imageButton.setBackgroundImage(image);
		
		SquareButton imageButton2 = new SquareButton(composite, SWT.NONE);
		imageButton2.setText("Button With Centered Image");
		imageButton2.setBackgroundImage(image);
		imageButton2.setBackgroundImageStyle(SquareButton.BG_IMAGE_CENTER);
		
		SquareButton imageButton3 = new SquareButton(composite, SWT.NONE);
		imageButton3.setText("Button With Stretched Image");
		imageButton3.setBackgroundImage(image);
		imageButton3.setBackgroundImageStyle(SquareButton.BG_IMAGE_STRETCH);
		
		SquareButton imageButton4 = new SquareButton(composite, SWT.NONE);
		imageButton4.setText("Button With Tiled Image");
		imageButton4.setBackgroundImage(image);
		imageButton4.setBackgroundImageStyle(SquareButton.BG_IMAGE_TILE);
		
		
		// a larger background image that's bigger than the button itself
		image = new Image(getShell().getDisplay(), IMG2_PATH);
		imageButton = new SquareButton(composite, SWT.NONE);
		imageButton.setText("Button With Cropped Image");
		imageButton.setBackgroundImage(image);
		
		imageButton2 = new SquareButton(composite, SWT.NONE);
		imageButton2.setText("Button With Centered Image");
		imageButton2.setBackgroundImage(image);
		imageButton2.setBackgroundImageStyle(SquareButton.BG_IMAGE_CENTER);
		
		imageButton3 = new SquareButton(composite, SWT.NONE);
		imageButton3.setText("Button With Stretched Image");
		imageButton3.setBackgroundImage(image);
		imageButton3.setBackgroundImageStyle(SquareButton.BG_IMAGE_STRETCH);
		
		imageButton4 = new SquareButton(composite, SWT.NONE);
		imageButton4.setText("Button With Tiled Image");
		imageButton4.setBackgroundImage(image);
		imageButton4.setBackgroundImageStyle(SquareButton.BG_IMAGE_TILE);
		
		imageButton4 = new SquareButton(composite, SWT.NONE);
		imageButton4.setText("Button With Side Image");
		imageButton4.setImage(image);
		
		imageButton4 = new SquareButton(composite, SWT.NONE);
		imageButton4.setText("\n\n\nFit to Image");
		imageButton4.setBackgroundImage(image);
		imageButton4.setBackgroundImageStyle(SquareButton.BG_IMAGE_FIT);
		
		
		// linefeeds in button text work too
		imageButton4 = new SquareButton(composite, SWT.NONE);
		imageButton4.setText("Button \nWith \nSide \nImage ");
		imageButton4.setImage(image);
		
		imageButton4 = new SquareButton(composite, SWT.NONE);
		imageButton4.setText("Button\nWith\nLine\nFeeds");
		
		
		// buttons that stretch and resize inside a FillLayout
		Composite buttonBar = new Composite(composite, SWT.NONE);
		buttonBar.setLayout(new FillLayout());
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = 2;
		buttonBar.setLayoutData(data);
		
		SquareButton barButton = new SquareButton(buttonBar, SWT.NONE);
		barButton.setRoundedCorners(false);
		barButton.setText("Fill Button 1");
		barButton = new SquareButton(buttonBar, SWT.NONE);
		barButton.setRoundedCorners(false);
		barButton.setText("Fill Button 2");
		barButton = new SquareButton(buttonBar, SWT.NONE);
		barButton.setRoundedCorners(false);
		barButton.setText("Fill Button 3");
		barButton = new SquareButton(buttonBar, SWT.NONE);
		barButton.setRoundedCorners(false);
		barButton.setText("Fill Button 4");
		
		
		return parent;
	}
	
	public SquareButton getGrayButton (Composite parent) {
		SquareButton button = new SquareButton(parent, SWT.NONE);
		
		button.setInnerMarginHeight(6);
		button.setInnerMarginWidth(24);
		button.setSelectionBorder(true);
		
		FontData[] fontData = JFaceResources.getDialogFont().getFontData();
		Font font = getSavedFont(fontData[0].getName(), fontData[0].getHeight(), SWT.BOLD | fontData[0].getStyle());
		Color purple = getSavedColor(120, 80, 220);
		Color blue = getSavedColor(40, 40, 180);
		Color red = getSavedColor(200, 100, 50);
		Color grayStart = getSavedColor(220, 220, 220);
		Color grayEnd = getSavedColor(160, 160, 160);
		Color inactiveStart = getSavedColor(250, 250, 250);
		Color inactiveEnd = getSavedColor(220, 220, 220);
		Color hoverStart = getSavedColor(180, 180, 180);
		Color hoverEnd = getSavedColor(140, 140, 140);
		Color clickStart = hoverStart;
		Color clickEnd = hoverStart;
		
		button.setFont(font);
		button.setBorderWidth(0);
		button.setDefaultColors(grayStart, grayEnd, purple, purple);
		button.setHoverColors(hoverStart, hoverEnd, blue, blue);
		button.setSelectedColors(grayStart, grayEnd, purple, purple);
		button.setClickedColors(clickStart, clickEnd, red, red);
		button.setInactiveColors(inactiveStart, inactiveEnd, button.getBackground(), purple);
		
		return button;
	}
	
	
	public SquareButton getCustomButton (Composite parent) {
		SquareButton button = new SquareButton(parent, SWT.NONE);
		
		button.setInnerMarginHeight(6);
		button.setInnerMarginWidth(24);
		button.setRoundedCorners(false);
		
		FontData[] fontData = JFaceResources.getDialogFont().getFontData();
		Font font = getSavedFont(fontData[0].getName(), fontData[0].getHeight()+4, fontData[0].getStyle());
		Color white = getSavedColor(255, 255, 255);
		Color blueFont = getSavedColor(50, 100, 200);
		Color orangeFont = getSavedColor(200, 80, 80);
		Color lightBlueStart = getSavedColor(255, 255, 200);
		Color lightBlueEnd = getSavedColor(180, 180, 80);
		Color inactiveStart = getSavedColor(250, 250, 250);
		Color inactiveEnd = getSavedColor(220, 220, 220);
		Color hoverStart = getSavedColor(200, 255, 255);
		Color hoverEnd = getSavedColor(80, 180, 180);
		Color clickStart = hoverEnd;
		Color clickEnd = hoverEnd;
		
		button.setFont(font);
		button.setDefaultColors(lightBlueStart, lightBlueEnd, blueFont, blueFont);
		button.setHoverColors(hoverStart, hoverEnd, blueFont, blueFont);
		button.setSelectedColors(lightBlueStart, lightBlueEnd, orangeFont, orangeFont);
		button.setClickedColors(clickStart, clickEnd, white, white);
		button.setInactiveColors(inactiveStart, inactiveEnd, button.getBackground(), white);
		
		return button;
	}
	
	
	private Color getSavedColor (int r, int g, int b) {
		String colorString = "COLOR:" + r + "-" + g + "-" + b;
		ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
		if (!colorRegistry.hasValueFor(colorString)) {
			colorRegistry.put(colorString, new RGB(r, g, b));
		}
		return colorRegistry.get(colorString);
	}
	
	
	private Font getSavedFont (String fontName, int fontSize, int fontStyle) {
		String fontString = "FONT:" + fontName + "-" + fontSize + "-" + fontStyle;
		FontRegistry fontRegistry = JFaceResources.getFontRegistry();
		if (!fontRegistry.hasValueFor(fontString)) {
			fontRegistry.put(fontString, new FontData[]{ new FontData(fontName, fontSize, fontStyle) });
		}
		return fontRegistry.get(fontString);
	}
	
}
