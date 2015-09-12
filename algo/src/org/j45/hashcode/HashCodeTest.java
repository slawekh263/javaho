package org.j45.hashcode;

import java.util.HashSet;
import java.util.Set;

public class HashCodeTest {

	public static void main(String[] args) {
		
		Space s1 = new Space("0912309", "Konferencja");
		Space s2 = new Space("2348943849", "Weekly videomeeting");
		Space s3 = new Space("0912309", "Conference");
		
		System.out.println("Space equals: " + s1.equals(s2));
		System.out.println("Space equals: " + s1.equals(s3));
		
		Set<Space> spaces = new HashSet<Space>();
		spaces.add(s1);
		System.out.println("Do i have s3? : " + spaces.contains(s3));
	}
	
	public static class Space {
		private String id;
		private String name;

		public Space(String _id, String _name) {
			this.id = _id;
			this.name = _name;
		}
		
		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}

		// TODO comment out to see incorrect result of HashSet search
		@Override
		public int hashCode() {
			int hash = 0;
			if(this.id != null) {
				hash = this.id.hashCode();
			}
			System.out.println("Hash: " + hash);
			return hash;
		}

		public boolean equals(Object obj) {
			boolean equal = false;
			Space spaceObj = null;
					
			if(obj != null && obj instanceof Space) {
				spaceObj = (Space) obj;
				if(spaceObj.getId().equals(this.getId())) {
					equal = true;
				}
			}
			return equal;
		}
	}

}
