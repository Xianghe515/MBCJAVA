package ch18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileEx1 {

	/*
	 * File 클래스 : file 객체를 생성하는 클래스. 파일(과 디렉토리)과 관련된 작업을 진행할 수 있음
	 * 
	 * env_path 값 세팅 방법? - windows + R > cmd 입력 후 엔터 > 명령 프롬프트 창 > 여기서 path라고 입력해서
	 * 엔터 > "PATH=" 뒤에 있는 문자열 복사(문자 선택해서 우클릭)해서 FileExample1.java 코드의 변수값으로 지정 - 주의)
	 * "" 안에서 ctrl + v 할 것(이스케이프 문자때문에 값이 안들어갈 수 있음) - 참고) 역슬래쉬, 이스케이프 문자, ...
	 */

	static String env_path = "C:\\Program Files\\Python313\\Scripts\\;C:\\Program Files\\Python313\\;%JAVA_HOME%\\bin;C:\\Program Files\\Common Files\\Oracle\\Java\\javapath;C:\\WINDOWS\\system32;C:\\WINDOWS;C:\\WINDOWS\\System32\\Wbem;C:\\WINDOWS\\System32\\WindowsPowerShell\\v1.0\\;C:\\WINDOWS\\System32\\OpenSSH\\;C:\\Program Files (x86)\\NVIDIA Corporation\\PhysX\\Common;C:\\Program Files (x86)\\Windows Kits\\10\\Windows Performance Toolkit\\;C:\\Users\\Admin\\AppData\\Local\\Programs\\Python\\Launcher\\;C:\\Users\\Admin\\AppData\\Local\\Microsoft\\WindowsApps;C:\\Users\\Admin\\AppData\\Local\\Programs\\Microsoft VS Code\\bin";

	public static void main(String[] args) {
		// File 객체 생성
		File f = new File("D:/Temp/a.txt"); // 일반 파일 정보를 담은 객체
		File dir = new File("./"); // 디렉토리 파일 정보를 담은 객체
		// └ 현재 디렉토리를 의미

		// 1. exists : 파일 혹은 디렉토리의 존재 여부 확인
		System.out.println("exists? : " + f.exists());
		System.out.println("exists? : " + dir.exists());

		// 2. isDirectory : 디렉토리인지 여부 확인(파일이면 false)
		System.out.println("isDirectory? : " + f.isDirectory());
		System.out.println("isDirectory? : " + dir.isDirectory());

		// 3. isAbsolute : 해당 경로가 절대 경로인지 여부 확인
		// 절대 경로 : 최상이 디렉터리부터 모든 경로를 다 표시하는 경우
		// C:\Program files\java\jdk-21\bin\java.exe
		// D:\Temp\a.txt
		// File 작업에서 디렉터리 구분값을 "\\" 또는 "/"
		// 상대 경로 : 현재 작업 위치로부터 경로를 표시하는 경우
		// ./ : 현재 디렉터리, ../ : 상위 디렉터리(바로 위)
		// ../test/test.txt -> 부모 디렉터리에서 test디렉터리에 있는 test.txt 파일
		System.out.println("isAbsolute?" + f.isAbsolute());
		System.out.println("isAbsolute?" + dir.isAbsolute());

		// 4. canExecute, canRead, canWrite
		System.out.println("a.txt can Execute? " + f.canExecute());
		System.out.println("a.txt can Read? " + f.canRead());
		System.out.println("a.txt can Write? " + f.canWrite());
//	    a.txt can Execute? true
//	    a.txt can Read? true
//	    a.txt can Write? true

		// 5. 절대 경로 반환(상대 경로를 절대 경로로 찾아줌)
		System.out.println("dir(./) AbsolutePath: " + dir.getAbsolutePath());
//	    dir(./) AbsolutePath: D:\[KDT]AI-cha-2024\JAVAPROJECT\thisisjava\.

		// 6. 부모 폴더를 문자열로 반환 : getParent()
		String parentDir = f.getParent();
		System.out.println(parentDir);
//      a.txt의 parent directory(문자열, String 타입): D:\Test

		// 7. 부모 폴더를 file 객체를 반환 : getParentFile()
		File f_parent = f.getParentFile();
		System.out.println(f_parent);
//      a.txt의 parent File(객체, Object 타입): D:\Test

		// 8. File 상수값 : 구분값 기호
		System.out.println(File.separator); // 결과 : \ (디렉토리 구분값)
		System.out.println(File.separatorChar); // 결과 : \
		System.out.println(File.pathSeparator); // 결과 : ; (경로 구분값)
		System.out.println(File.pathSeparatorChar); // 결과 : ;

		// 환경 변수
		String[] path = env_path.split(File.pathSeparator); // 경로 구분값으로 env_path를 나눔

		for (String p : path) {
			System.out.println(p);
		}

		// 파일 생성・수정・삭제 메소드
		File test = new File("D:/Temp/temp/abc");
		// mkdir : 해당 경로에 폴더(디렉토리)를 만듦 * mkdir : make diretory
		// mkdirs : 존재하지 않는 부모 폴더(디렉토리)까지 모두 포함해서 폴더 생성
		if (!test.exists()) {
//			test.mkdir();
			test.mkdirs();
		}
		// mkdir은 경로에 부모 디렉토리 중 하나라도 없으면 생성 불가
		// mkdirs는 Temp 내 temp라는 폴더가 없더라도 temp에 더불어 abc까지 생성해줌
		// - 반환 타입 boolean

		// createNewFile : 파일이 없으면 새로 생성 - 반환 타입 boolean
		test = new File("D:/Temp/filetest3/test/a.txt");

//		try {
//			test.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("파일 생성 중 에러가 발생했음");
//		}		컴파일 에러 => java.io.IOException: 지정된 경로를 찾을 수 없습니다

		try {
			File testDir = test.getParentFile(); // 부모 디렉토리를 File 객체로 반환
			if (!testDir.exists()) { // 디렉토리가 존재하지 않는다면
				testDir.mkdirs(); // 디렉토리를 생성
				System.out.println("디렉토리 생성"); // 디렉토리 생성을 성공하면 "디렉토리 생성"을 출력
				if (test.createNewFile()) {
					System.out.println("파일 생성");
				} else {
					System.out.println("파일 생성 실패");
				}
			} else {
				System.out.println("디렉토리 생성 실패");
				throw new FileNotFoundException("파일 경로를 찾지 못함");
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일 생성 중 에러가 발생했음");
		}

		// 디렉토리 내 정보 확인 : listFiles() - 디렉토리 내용 출력
		File[] dirFiles = f_parent.listFiles();
		System.out.println("D:\\Temp 디렉토리 내용");
		for (File af : dirFiles) {
			System.out.println(af);
		}
		System.out.println();

		// delete : 파일이나 디렉토리를 삭제. 디렉토리는 비어있지 않으면 삭제 불가(디렉토리 내 파일을 먼저 삭제하지 않으면 불가)
		test = new File("D:/Temp/filetest3/test/a.txt");

		if (!test.delete()) { // 삭제 실패 시
			if (test.isDirectory()) {
				System.out.println("디렉토리 삭제 실패");
				System.out.println(test + "디렉토리가 비어있지 않음");
				for (File df : test.listFiles()) {
					if (!df.delete()) {
						System.out.println(df + "삭제 실패!");
					} else {
						System.out.println("삭제 성공");
					}
				}
				if (test.delete()) {
					System.out.println("디렉토리 삭제 성공");
				}
			} else {
				System.out.println("파일 삭제 실패");
			}
		} else {
			System.out.println("디렉토리 삭제 성공");
		}

	}

}
