class Solution {
    public List<String> removeSubfolders(String[] folder) {
      Arrays.sort(folder);
      List<String> result = new ArrayList<>();
      
      String previousFolder = null;

      for (String currentFolder : folder) {
        if (!currentFolder.startsWith(previousFolder + "/")) {
            previousFolder = currentFolder;
            result.add(currentFolder);
        }
      } 
      return result;
    }
}