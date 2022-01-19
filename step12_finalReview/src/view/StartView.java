package view;

import java.util.Scanner;

import controller.MovieSystemController;
import moviedto.ActorDTO;
import moviedto.MovieCategori;
import moviedto.MovieDTO;

public class StartView {

	public static void main(String args[]) {

		MovieDTO md1 = new MovieDTO("�����", "�ֿ��", 131, "���");
		MovieDTO md2 = new MovieDTO("����", "�ֿ��", 125, "������");
		MovieDTO md3 = new MovieDTO("����ǽð�", "������", 134, "������");
		MovieDTO md4 = new MovieDTO("����", "�۰�ȣ", 119, "����");
		MovieDTO md5 = new MovieDTO("�ýÿ�����", "�۰�ȣ", 137, "���");
		MovieDTO md6 = new MovieDTO("�ڸ���", "��γ�", 127, "���");

		ActorDTO ac1 = new ActorDTO("�ֿ��", 30, 181);
		ActorDTO ac2 = new ActorDTO("�۰�ȣ", 56, 180);
		ActorDTO ac3 = new ActorDTO("������", 38, 176);
		ActorDTO ac4 = new ActorDTO("��γ�", 43, 170);

		MovieCategori mcarr[] = {	new MovieCategori(md1, ac1, "�Ͽ��� 14��", 10000),
									new MovieCategori(md2, ac1, "����� 14��", 12000), 
									new MovieCategori(md3, ac3, "�Ͽ��� 17��", 14000),
									new MovieCategori(md4, ac2, "�Ͽ��� 12��", 10000), 
									new MovieCategori(md5, ac2, "����� 10��", 9000),
									new MovieCategori(md6, ac4, "����� 18��", 12000) };
		
//		
//=====================================================================================================================================//
//
		
		
		MovieSystemController movieController = MovieSystemController.getInstance();
		
		//��Ʈ�ѷ� ������ ���� ���� -> ��� ���� === ���񽺿����� ����� ����
		
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);

		for (int index = 0; index < mcarr.length; index++) {
			movieController.movieListCreate(mcarr[index]);
		}
		
		System.out.println(" ***��ȭ ���� �˻�������Դϴ�.*** \n 1. ��� ��ȭ �˻� \n 2. ��ȭ ���� �˻� \n 3. ���� ��ȭ �󿵽ð� ���� "
							+ "\n 4. ��� ���� �˻� \n 5. ��� �⿬�� �˻� \n 6. ��ȭ �帣 �˻� \n 7. ��ȭ �� ����\n 0���� ������");

		
		
		int i = sc.nextInt();

		while (i != 0) {

			if (i == 1) {

				System.out.println("\n*** 01. ��� ��ȭ �˻� ***");
				movieController.getMovieProjectsList();

			} else if (i == 2) {

				System.out.println(" *** ��ȭ�̸��� �Է����ּ���. ***");
				String mName = sc1.nextLine();
				System.out.println("\n*** 02. " + mName + " ��ȭ �˻� ***");
				movieController.getMovieProject(mName);

			} else if (i == 3) {

				System.out.println(" *** ��ȭ�̸��� �Է����ּ���. ***");
				String mName = sc1.nextLine();

				System.out.println("\n*** 03. " + mName + "��ȭ �󿵽ð� ���� ***\n �����ϰ��� �ϴ� �ð��� 'x���� xx��' �� ǥ�����ּ���.");
				String mTime = sc1.nextLine();
				movieController.movieListUpdata(mName, mTime);

			} else if (i == 4) {

				System.out.println(" *** ����̸��� �Է����ּ���. ***");
				String mName = sc1.nextLine();

				System.out.println("\n*** 04. " + mName + " Actor �˻� ***");
				movieController.actorInfoRead(mName);

			} else if (i == 5) {

				System.out.println(" *** ��� �̸��� �Է����ּ��� ***");
				String mName = sc1.nextLine();

				System.out.println("\n*** 05. " + mName + " �⿬ ��ȭ �˻� ***");
				movieController.actorMovieListAdd(mName);

			} else if (i == 6) {

				System.out.println(" *** ���ϴ� �帣�� �Է����ּ��� ***");
				String mName = sc1.nextLine();

				System.out.println("\n*** 06. " + mName + " �帣 ��ȭ �˻� ***");
				movieController.movieGenreListAdd(mName);

			} else if (i == 7) {

				System.out.println(" ***�����ϰ��� �ϴ� ��ȭ�̸��� �Է����ּ���. ***");

				String mName = sc1.nextLine();
				System.out.println("\n*** 07. " + mName + " ��ȭ ���� �� ������ ��ȭ �˻� ***");

				movieController.movieListDelete(mName);
				movieController.getMovieProjectsList();

			}
			System.out.println("\n ***��ȭ ���� �˻�������Դϴ�.*** \n 1. ��� ��ȭ �˻� \n 2. ��ȭ ���� �˻� \n 3. ���� ��ȭ �󿵽ð� ���� "
								+ "\n 4. ��� ���� �˻� \n 5. ��� �⿬�� �˻� \n 6. ��ȭ �帣 �˻� \n 7. ��ȭ �� ����\n 0���� ������");

			i = sc.nextInt();

		} // While End Point

		System.out.println(" ***����̰� ����Ǿ����ϴ�.***");

	} // Main End Point

} // Class End Point
