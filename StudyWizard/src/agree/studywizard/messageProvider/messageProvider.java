package agree.studywizard.messageProvider;

public class messageProvider implements IMessageProvider{

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "欢迎信息";
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "这是扩展点提供的欢迎信息";
	}


}
