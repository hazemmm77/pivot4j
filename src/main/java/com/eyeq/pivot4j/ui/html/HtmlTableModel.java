/*
 * ====================================================================
 * This software is subject to the terms of the Common Public License
 * Agreement, available at the following URL:
 *   http://www.opensource.org/licenses/cpl.html .
 * You must accept the terms of that agreement to use this software.
 * ====================================================================
 */
package com.eyeq.pivot4j.ui.html;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.eyeq.pivot4j.ui.TableModel;

public class HtmlTableModel extends AbstractHtmlElement implements
		TableModel<HtmlTableRow> {

	private static final long serialVersionUID = 2154755695117603346L;

	private List<HtmlTableRow> headers = new ArrayList<HtmlTableRow>();

	private List<HtmlTableRow> rows = new ArrayList<HtmlTableRow>();

	private String id;

	private Integer border;

	private Integer cellSpacing;

	private Integer cellPadding;

	private String headerStyleClass;

	private String bodyStyleClass;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @see com.eyeq.pivot4j.ui.TableModel#getHeaders()
	 */
	@Override
	public List<HtmlTableRow> getHeaders() {
		return headers;
	}

	/**
	 * @see com.eyeq.pivot4j.ui.TableModel#getRows()
	 */
	@Override
	public List<HtmlTableRow> getRows() {
		return rows;
	}

	/**
	 * @see com.eyeq.pivot4j.ui.TableModel#getHeaderCount()
	 */
	@Override
	public int getHeaderCount() {
		return headers.size();
	}

	/**
	 * @see com.eyeq.pivot4j.ui.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return rows.size();
	}

	/**
	 * @return the cellSpacing
	 */
	public Integer getCellSpacing() {
		return cellSpacing;
	}

	/**
	 * @param cellSpacing
	 *            the cellSpacing to set
	 */
	public void setCellSpacing(Integer cellSpacing) {
		this.cellSpacing = cellSpacing;
	}

	/**
	 * @return the cellPadding
	 */
	public Integer getCellPadding() {
		return cellPadding;
	}

	/**
	 * @param cellPadding
	 *            the cellPadding to set
	 */
	public void setCellPadding(Integer cellPadding) {
		this.cellPadding = cellPadding;
	}

	/**
	 * @return the border
	 */
	public Integer getBorder() {
		return border;
	}

	/**
	 * @param border
	 *            the border to set
	 */
	public void setBorder(Integer border) {
		this.border = border;
	}

	/**
	 * @return the headerStyleClass
	 */
	public String getHeaderStyleClass() {
		return headerStyleClass;
	}

	/**
	 * @param headerStyleClass
	 *            the headerStyleClass to set
	 */
	public void setHeaderStyleClass(String headerStyleClass) {
		this.headerStyleClass = headerStyleClass;
	}

	/**
	 * @return the bodyStyleClass
	 */
	public String getBodyStyleClass() {
		return bodyStyleClass;
	}

	/**
	 * @param bodyStyleClass
	 *            the bodyStyleClass to set
	 */
	public void setBodyStyleClass(String bodyStyleClass) {
		this.bodyStyleClass = bodyStyleClass;
	}

	/**
	 * @see com.eyeq.pivot4j.ui.html.HtmlElement#writeHtml(java.io.PrintWriter,
	 *      int)
	 */
	@Override
	public void writeHtml(PrintWriter writer, int indent) {
		for (int i = 0; i < indent; i++) {
			writer.print('\t');
		}

		writer.print("<table");
		writeAttributes(writer);
		writer.println('>');

		indent++;

		if (!headers.isEmpty()) {
			for (int i = 0; i < indent; i++) {
				writer.print('\t');
			}

			writer.print("<thead");

			if (getHeaderStyleClass() != null) {
				writer.print(" class=\"");
				writer.print(getHeaderStyleClass());
				writer.print("\"");
			}

			writer.println(">");

			indent++;
			writeHeader(writer, indent);
			indent--;

			for (int i = 0; i < indent; i++) {
				writer.print('\t');
			}

			writer.println("</thead>");
		}

		if (!rows.isEmpty()) {
			for (int i = 0; i < indent; i++) {
				writer.print('\t');
			}

			writer.print("<tbody");

			if (getBodyStyleClass() != null) {
				writer.print(" class=\"");
				writer.print(getBodyStyleClass());
				writer.print("\"");
			}

			writer.println(">");

			indent++;
			writeBody(writer, indent);
			indent--;

			for (int i = 0; i < indent; i++) {
				writer.print('\t');
			}

			writer.println("</tbody>");
		}

		writer.println("</table>");
	}

	/**
	 * @param writer
	 */
	protected void writeAttributes(PrintWriter writer) {
		if (getId() != null) {
			writer.print(" id=\"");
			writer.print(getId());
			writer.print("\"");
		}

		if (getStyleClass() != null) {
			writer.print(" class=\"");
			writer.print(getStyleClass());
			writer.print("\"");
		}

		if (getStyle() != null) {
			writer.print(" style=\"");
			writer.print(getStyle());
			writer.print("\"");
		}

		if (cellSpacing != null) {
			writer.print(" cellspacing=\"");
			writer.print(cellSpacing);
			writer.print("\"");
		}

		if (cellPadding != null) {
			writer.print(" cellpadding=\"");
			writer.print(cellPadding);
			writer.print("\"");
		}

		if (border != null) {
			writer.print(" border=\"");
			writer.print(border);
			writer.print("\"");
		}
	}

	/**
	 * @param writer
	 * @param indent
	 */
	protected void writeHeader(PrintWriter writer, int indent) {
		for (HtmlTableRow row : getHeaders()) {
			row.writeHtml(writer, indent);
		}
	}

	/**
	 * @param writer
	 * @param indent
	 */
	protected void writeBody(PrintWriter writer, int indent) {
		for (HtmlTableRow row : getRows()) {
			row.writeHtml(writer, indent);
		}
	}
}