package kosta.mvc.model.service;
/**
 * ��� �Խ����� �������� ����ϰ� �� Service
 * (Business Logic)
 * */

import java.util.Map;

import kosta.mvc.model.dto.Board;
import kosta.mvc.model.exception.DuplicateException;
import kosta.mvc.model.exception.InexistentException;

public interface BoardService {
   /**
    *   ��� �Խù� �˻�
    *   @return : �Խ��� ������ ���� ��� �Խù� ������ Map�� ���·� ����
    *   @throws : �Խù��� �Ѱ��� ���� ���� �ʴ´ٸ� InexistentException ���ܰ�
    *             �߻��Ѵ�.
    * */
	Map<String, Map<String, Board>> getBoardList()throws InexistentException;
	
	/**
	 *�Խ���������(Kind)�� ���� �Խù� �˻��ϱ�
	 *  @return kind�� �ش��ϴ� ��ü�Խù� Map���� ����
	 *  @param :  �Խù������� ���� key�� �μ��� ���޹޴´�.
	 *  @throws : kind�� �ش��ϴ� �Խù��� �Ѱ��� ���� �� InexistentException���ܹ߻�
	 * */
	Map<String, Board> getBoardByKind(String kind)throws InexistentException;
	//kind - ��� �Խ��ǿ� ������.. ex) key - archive, photo.. 
	
	/**
	 *  �Խù� �������� �۹�ȣ�� �ش��ϴ� �Խù� �Ѱ��� �˻�
	 * @return �Խù� ���� �Ѱ��� Board ���·� ����
	 * @param kind�� �Խù� ����, no�� �Խù� �۹�ȣ
	 * @throws �˻��ϴ� �Խù��� ������ InexistentException ���ܹ߻�
	 * */
	Board getBoardByNo(String kind, int no)throws InexistentException;
	
	/**
	 *  �Խù� ����ϱ�
	 *  @return : true�̸�  ��ϼ���, false�̸� ��Ͻ���
	 *  @param : kind�� �߰��� �Խ�������, board�� �߰��� �Խù��� ����
	 *  @throws: ����ϱ� ���� �۹�ȣ �ߺ��� üũ�ؼ� �ߺ��̸� DuplicateException�߻�
	 *           ����� �����ϸ�  InexistentException �߻�
	 * */
	void insertBoard(String kind, Board board)throws DuplicateException, InexistentException;

   /**
    * 5. ������� ��ȣ �ߺ����� üũ �ϴ� ���
    *    @return : true�̸� �ߺ�, false�̸� �ߺ��ƴ�.
    *    @param : kind�� �Խ����� ����, no�� �۹�ȣ
    * */
	void duplicateByNo(String kind, int no);
	
	/**
	 * 6. �Խù� �����ϱ�
	 *  @return : true�̸� ��������, false�̸� ��������
	 *  @param : kind�� �Խ����� ����, no�� �۹�ȣ
	 *  @throws : ������ ���� ������ InexistentException ���� �߻�.
	 * */
	void deleteBoard(String kind, int no)throws InexistentException;
	
	/**
	 * 7. �Խù� �����ϱ�
	 *     ���� : ����, �ۼ���, ����
	 *     photo : imgName
	 *     archive : fileName, fileSize
	 *     
	 * @return :true�̸� ��������, false�̸� ��������
	 * @param : board�� ������ �Խù��� ����, kind�� ������ �Խù����ִ� �Խ���������
	 * @throws: �������� ������ InexistentException ���ܹ߻�
	 * */
	void updateBoard(Board board, String kind)throws InexistentException;
}










