
/**
    필드값에 따라서 우선순위가 정해져야 할때 사용했었던 Comparator
    해당 로직은 오름차순으로 정렬해주는 로직이다.
 */

public class CustomComparator{


    public void test(pageInfoList){
       List list =  Collections.sort(pageInfoList, new Comparator<PortfolioPageDefaultVO>() {
            @Override

            public int compare(PortfolioPageDefaultVO obj1, PortfolioPageDefaultVO obj2) {

            int result = 0;

            int result2 = 0;

            if (obj1.getPageType().equals("Cover")) {
                result = 1;
            } else if (obj1.getPageType().equals("List")) {
                result = 2;
            } else if (obj1.getPageType().equals("Resume")) {
                result = 3;
            } else if (obj1.getPageType().equals("Introduction")) {
                result = 4;
            } else if (obj1.getPageType().equals("Project")) {
                result = 5;
            } else if (obj1.getPageType().equals("Recommendation")) {
                result = 6;
            } else if (obj1.getPageType().equals("Contents")) {
                result = 7;
            } else if (obj1.getPageType().equals("GitLab")) {
                result = 8;
            } else if (obj1.getPageType().equals("Education")) {
                result = 9;
            } else if (obj1.getPageType().equals("Test")) {
                if (obj1.getSubTitle().equals("영어테스트")) {
                    result = 10;
                } else {
                    result = 11;
                }
            } else if (obj1.getPageType().equals("ResearchPaper")) {
                result = 12;
            } else if (obj1.getPageType().equals("Patent")) {
                result = 13;
            }

            if (obj2.getPageType().equals("Cover")) {
                result2 = 1;
            } else if (obj2.getPageType().equals("List")) {
                result2 = 2;
            } else if (obj2.getPageType().equals("Resume")) {
                result2 = 3;
            } else if (obj2.getPageType().equals("Introduction")) {
                result2 = 4;
            } else if (obj2.getPageType().equals("Project")) {
                result2 = 5;
            } else if (obj2.getPageType().equals("Recommendation")) {
                result2 = 6;
            } else if (obj2.getPageType().equals("Contents")) {
                result2 = 7;
            } else if (obj2.getPageType().equals("GitLab")) {
                result2 = 8;
            } else if (obj2.getPageType().equals("Education")) {
                result2 = 9;
            } else if (obj2.getPageType().equals("Test")) {

                if (obj2.getSubTitle().equals("영어테스트")) {
                    result2 = 10;
                } else {
                    result2 = 11;
                }
            } else if (obj2.getPageType().equals("ResearchPaper")) {
                result2 = 12;
            } else if (obj2.getPageType().equals("Patent")) {
                result2 = 13;
            }

            return result - result2;
            }

        });

​
    }
    
}