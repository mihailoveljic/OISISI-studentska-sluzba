package views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

	//	https://stackoverflow.com/questions/23856818/set-enable-button-if-text-field-is-fill
	public class ButtonEnabler implements DocumentListener {

     private ButtonModel buttonModel;
     private List<Document> documents = new ArrayList<Document>();

     public ButtonEnabler(ButtonModel buttonModel) {
         this.buttonModel = buttonModel;
     }

     public void addDocument(Document document) {
         document.addDocumentListener(this);
         this.documents.add(document);
         documentChanged();
     }

     public void documentChanged() {
         boolean buttonEnabled = true;
         for (Document document : documents) {
             if (document.getLength() <= 0) {
                 buttonEnabled = false;
                 break;
             }
         }
         buttonModel.setEnabled(buttonEnabled);
     }

		@Override
		public void insertUpdate(DocumentEvent e) {
			 documentChanged();
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			 documentChanged();
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			 documentChanged();			
		}
 }
