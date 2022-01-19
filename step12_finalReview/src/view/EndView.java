package view;

import java.util.ArrayList;
import java.util.HashMap;

import moviedto.ActorDTO;
import moviedto.MovieCategori;

public class EndView {

	
	public static void movieView(MovieCategori project) {
		if (project != null) {
			System.out.println(project);
		} else {
			System.out.println("�ش� ������Ʈ�� �������� �ʽ��ϴ�.");
		}
	}

	public static void movieListView(ArrayList<MovieCategori> allProbonoProject) {
		if (allProbonoProject != null) {
			for (int i = 0; i < allProbonoProject.size(); i++) {
				if (allProbonoProject.get(i) != null) {
					System.out.println(allProbonoProject.get(i));
				}
			}
		} else {
			System.out.println("�� ������Ʈ�� �� ���� �մϴ�.");
		}
	}

	public static void successView(String movieProject) {
		System.out.println(movieProject);
	}

	public static void moiveActorView(ActorDTO actorInfoRead) {
		System.out.println(actorInfoRead);
	}

	public static void hashName(HashMap<String, ArrayList<String>> actorInfoRead) {
		System.out.println(actorInfoRead.toString());
	}

//    public String toString() {
//        Iterator<Entry<K,V>> i = entrySet().iterator();
//        if (! i.hasNext())
//            return "{}";
//
//        StringBuilder sb = new StringBuilder();
//        sb.append('{');
//        for (;;) {
//            Entry<K,V> e = i.next();
//            K key = e.getKey();
//            V value = e.getValue();
//            sb.append(key   == this ? "(this Map)" : key);
//            sb.append('=');
//            sb.append(value == this ? "(this Map)" : value);
//            if (! i.hasNext())
//                return sb.append('}').toString();
//            sb.append(',').append(' ');
//        }
//    }
	
	
}	// Class End Point
