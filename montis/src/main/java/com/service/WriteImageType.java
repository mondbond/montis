package com.service;


import com.service.textparser.TextWord;
import com.service.textparser.dto.Paragraph;
import com.service.textparser.dto.TextSentence;
import com.service.textparser.dto.TextStructure;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

@Service
public class WriteImageType {


	public void draw(TextStructure textStructure, String path) {

		int width = 600, height = 200;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D ig2 = bi.createGraphics();
		ig2.setPaint(Color.black);

		int startX, startY;
		startX = 10;
		startY = 10;


		for (int paragraphN = 0; paragraphN < textStructure.getParagraphs().size(); paragraphN++){
			Paragraph currentParagraph = textStructure.getParagraphs().get(paragraphN);

			for (int sentenceN = 0; sentenceN < currentParagraph.getSentences().size(); sentenceN++){
				TextSentence currentSentence = currentParagraph.getSentences().get(sentenceN);

				for (int wordN = 0; wordN < currentSentence.getWords().size(); wordN++){
					TextWord  currentWord = currentSentence.getWords().get(wordN);

					ig2.setPaint(currentWord.isKnown()?Color.ORANGE: Color.GRAY);

					Rectangle shape = new Rectangle();

					shape.height = 3;
					shape.width = 5 * currentWord.getLength();

					shape.x = startX;
					shape.y = startY;

					ig2.fill(shape);
					ig2.draw(shape);


					startX += shape.width;
//					startY += shape.y;


					ig2.setPaint(Color.WHITE);
					shape = new Rectangle();

					shape.height = 3;
					shape.width = 5;

					shape.x = startX;
					shape.y = startY;

					ig2.fill(shape);
					ig2.draw(shape);


					startX += shape.width;
//					startY += shape.y;
				}

				ig2.setPaint(Color.BLACK);
				Rectangle shape = new Rectangle();

				shape.height = 7;
				shape.width = 2;

				shape.x = startX;
				shape.y = startY;

				ig2.fill(shape);
				ig2.draw(shape);

				startX += shape.width;
			}


		}

		try {
			ImageIO.write(bi, "PNG", new File(path + "/yourImageName.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	 public void draw(String name, String path) throws Exception {
		try {
			int width = 200, height = 200;


			// TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
			// into integer pixels
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

			Graphics2D ig2 = bi.createGraphics();


			Font font = new Font("TimesRoman", Font.BOLD, 20);
			ig2.setFont(font);
			String message = "www.java2s.com!";
			FontMetrics fontMetrics = ig2.getFontMetrics();
			int stringWidth = fontMetrics.stringWidth(message);
			int stringHeight = fontMetrics.getAscent();
			ig2.setPaint(Color.black);
			ig2.drawString(message, (width - stringWidth) / 2, height / 2 + stringHeight / 4);

			ImageIO.write(bi, "PNG", new File(path + "/yourImageName.PNG"));

		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}
}