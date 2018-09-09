package com.ediya.board.mindae.util;

public class MyUtil {
//
	// ��ü �������� ���ϱ�
	// numPerPage : ��ȭ�鿡 ǥ���� �������� ����
	// dataCount : ��ü�������� ����

	public int getPageCount(int numPerPage, int dataCount) {

		int pageCount = 0;

		pageCount = dataCount / numPerPage;

		if (dataCount % numPerPage != 0)
			pageCount++;

		return pageCount;
	}

	// ����¡ó�� �޼ҵ�
	// currentPage : ���� ǥ���� ������
	// totalPage : ��ü ������ ��
	// listUrl : ��ũ�� ������ url
	public String pageIndexList(int currentPage, int totalPage, String listUrl) {

		int numPerBlock = 5;

		int currentPageSetup;// numPerBlock�� ù��° ���ڿ��� -1

		int page;

		StringBuffer sb = new StringBuffer();

		if (currentPage == 0 || totalPage == 0)
			return "";

		// list.jsp?pageNum=2
		// list.jsp?searchKey=subject&searchValue=3&pageNum=2
		if (listUrl.indexOf("?") != -1) {
			listUrl = listUrl + "&";
		} else {
			listUrl = listUrl + "?";
		}

		// currentPageSetup ���ϱ�
		currentPageSetup = (currentPage / numPerBlock) * numPerBlock;
		// < 11 12 13 14 15>
		// currentPaget=13 -> 13/5(numPerBlock)*5(numPerBlock)
		// ->currentPageSetup =10 ->10����������

		if (currentPage % numPerBlock == 0)
			currentPageSetup = currentPageSetup - numPerBlock;

		// ������ �����

		if (totalPage > numPerBlock && currentPageSetup > 0) {
			sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup
					+ "\">������</a>&nbsp;");
			// <a href="list.jsp?pageNum=5>������</a>&nbsp;
		}

		// �ٷΰ��� page
		page = currentPageSetup + 1;
		while (page <= totalPage && page <= (currentPageSetup + numPerBlock)) {

			if (page == currentPage) {

				sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
				// <font color="Funchsia">9</font>&nbsp;

			} else {

				sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">"
						+ page + "</a>&nbsp;");
				// <a href = "list.jsp?pageNum=6">6</a>&nbsp;
			}
			page++;

		}
		//������
		if(totalPage-currentPageSetup>numPerBlock){
			
			sb.append("<a href=\"" + listUrl + "pageNum=" +
					page + "\">������</a>&nbsp;" );
			//<a href="list.jsp?pageNum=11">������</a>&nbsp;
				
		}
		return sb.toString();
	}

}
