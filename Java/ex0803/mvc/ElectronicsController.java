
//view�� model ���̿��� �߰������� ���ִ� ������
//view���� ������ ��û�� ���� �׿� �ش��ϴ� service�� �ϰ�
//�� ȣ��� ����� �޾� ����� ������ �����ϴ� ������ �Ѵ� 
class ElectronicsController{
	private ElectronicsService service = ElectronicsService.getInstance(); 

	//���
	public void insert(Electronics electronics){
		boolean result = service.insert(electronics);
		if(result){
			EndView.printMessage("��ϵǾ����ϴ�");
		}else{
			EndView.printMessage("��ϵ��� �ʾҽ��ϴ�");
			
		}
	}

	//��ü�˻�

	//�۹�ȣ �˻�

	//�����ϱ�


}