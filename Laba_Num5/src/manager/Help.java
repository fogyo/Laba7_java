package manager;

public class Help extends Command{
	
	private String str =  "help : вывести справку по доступным командам\r\n"
			+ "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\r\n"
			+ "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\r\n"
			+ "insert null {element} : добавить новый элемент с заданным ключом\r\n"
			+ "update id {element} : обновить значение элемента коллекции, id которого равен заданному\r\n"
			+ "remove_key null : удалить элемент из коллекции по его ключу\r\n"
			+ "clear : очистить коллекцию\r\n"
			+ "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\r\n"
			+ "exit : завершить программу (без сохранения в файл)\r\n"
			+ "history : вывести последние 13 команд (без их аргументов)\r\n"
			+ "replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого\r\n"
			+ "remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный\r\n"
			+ "sum_of_engine_power : вывести сумму значений поля enginePower для всех элементов коллекции\r\n"
			+ "print_unique_capacity : вывести уникальные значения поля capacity всех элементов в коллекции\r\n"
			+ "print_field_descending_engine_power : вывести значения поля enginePower всех элементов в порядке убывания";
	
	@Override
	public void run() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	
	public String getString() {
		return str;
	}

}
