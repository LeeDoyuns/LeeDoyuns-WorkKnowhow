

/**
    파일 처리 Controller
    서버에 임시파일 생성해서 read한 후 삭제처리한다.
 */
public class CsvFileReader {
    
    @RequestMapping(value="/....../readCsv", method={RequestMethod.POST},consumes="multipart/form-data" )
    public Map<String,Object> readCsv(MultipartHttpServletRequest req){
        
        MultipartFile file = req.getFile("file");

        if(file != null){
            try{
                File tempFile = new File("파일 업로드할 경로/timestamp.csv");
                file.transferTo(tempFile);
                List result = csvReader(tempFile); 
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public List csvReader(File file){
        BufferedReader reader = null;
        FileInputStream fis = null;

        String sep = ",";

        try{
            String line=null;
            String[] record = null;

            //파일 인코딩 확인
            fis == new FileInputStream(file);
            byte[] BOM = new byte[4];
            fis.read(BOM,0,4);

            //UTF-8인 경우
            if((BOM[0] & 0xFF) == 0xEF && (BOM[1] & 0xFF) == 0xBB && (BOM[2] & 0xFF) == 0xBF){
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            }else{  //UTF-8이 아닌경우(ANSI).
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"EUC-KR")); //UTF-8로 읽으면 한글 깨짐
            }

            fis.close();

            List list = new ArrayList();

            while((line=reader.readLine())!=null){
                line = line.replace("\"","");
                Map map = new HashMap();
                record = line.split(sep);   //"csv의 구분자인 , 로 split"
                for(int i=0;i<record.length;i++){
                    list.add(record[i]);
                }
            }
            reader.close();


        }catch(Exception e){
            e.getMessage();
        }finally{
            if(file.exists()){
                file.delete();
            }
        }
    }
}