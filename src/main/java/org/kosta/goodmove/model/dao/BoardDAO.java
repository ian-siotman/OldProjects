package org.kosta.goodmove.model.dao;

import java.util.List;

import org.kosta.goodmove.model.vo.ApplicationVO;
import org.kosta.goodmove.model.vo.BoardPagingBean;
import org.kosta.goodmove.model.vo.BoardVO;
import org.kosta.goodmove.model.vo.ProductVO;
import org.kosta.goodmove.model.vo.TransactionVO;

public interface BoardDAO {

	int getNextBno();

	int getNextAno();

	int getNextTno();

	int getNextPno();

	int getTotalBoardCount();

	List<BoardVO> getAllBoardList(BoardPagingBean pagingBean);

	void boardRegister(BoardVO bvo);

	BoardVO getBoardDetailByBno(int bno);

	List<ProductVO> getProductImgByBno(int bno);

	void registerApplication(ApplicationVO avo);

	void registerTransaction(TransactionVO tvo);

	int getTotalBoardCount(String id);

	List<BoardVO> getMyBoardList(BoardPagingBean pagingBean, String id);

	List<ApplicationVO> getApplications(int bno);
	
	int isGiveMeChecked(ApplicationVO avo);

	ProductVO getProductByPno(String pno);

	void confirmApply(String ano);

	void nowUnavailable(String pno);

	ApplicationVO getApplicationByAno(String ano);

	void Refresh(int bno);

	int selectedProductCnt(int bno);
}
