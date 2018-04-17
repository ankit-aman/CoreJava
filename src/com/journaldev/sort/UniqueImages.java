package com.journaldev.sort;
import java.util.*;

class UniqueImages {
    public static class Image {
        private String filename;
        private Integer width;
        private Integer height;
        
        
        public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		public Integer getWidth() {
			return width;
		}
		public void setWidth(Integer width) {
			this.width = width;
		}
		public Integer getHeight() {
			return height;
		}
		public void setHeight(Integer height) {
			this.height = height;
		}
		public Image(String filename, Integer width, Integer height) {
            this.filename = filename;
            this.width = width;
            this.height = height;
        }
        @Override
		public int hashCode() {
			final int prime = 31;
			int result = 0;
			result = prime * result + ((filename == null) ? 0 : filename.hashCode());
			//result = prime * result + height;
			//result = prime * result + width;
			return result;
		}
        /**
         * Two Images are considered equal if they have
         * the same filename (without the extension), and the
         * same number of pixels.
         * Thus, flag.jpg with width=60 height=40 is
         * equal to flag.gif with width=40 and height=60
         */
        @Override
        public boolean equals(Object other) {
            Image o = (Image)other;
            if (filename == null || o.filename == null)
                return false;
            String[] components = filename.split("\\.");
            String[] ocomponents = o.filename.split("\\.");
            System.out.println(components[0]+ocomponents[0]) ;
            return components[0].equalsIgnoreCase(ocomponents[0]) && 
                width * height == o.width * o.height;
        }
        @Override
        public String toString() {
            return "Image: filename=" + filename + " Size=" + width*height;
        }
    }

    public static void printImages(Set<Image> images) {
        for(Image image: images) {
            System.out.println(image);
        }
    }

    public static void main(String[] args) {
        Image[] images = {new Image("flag.jpg", 40, 60),
                          new Image("flag.gif", 40, 60),
                          new Image("smile.gif", 100, 200),
                          new Image("smile.gif", 50, 400),
                          new Image("other.jpg", 40, 60),
                          new Image("lenna.jpg", 512, 512),
                          new Image("Lenna.jpg", 512, 512)};
        HashSet<Image> set = new HashSet<Image>(Arrays.asList(images));
        
        UniqueImages.printImages(set);
    }
}
