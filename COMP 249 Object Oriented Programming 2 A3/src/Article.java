/** -----------------------------------------------------
 *Assignment 3 Bibliography Creator
 *Question: 3-7
 *Written by: Shereece A.A. Victor 40105094
 *-----------------------------------------------------
 */

/**
 * Article Class
 *
 * Stores data on an article extracted from a bib file
 */
public class Article {
    /**
     *Stores the authors of an article
     */
    String [] authors;

    /**
     * Stores the name of the journal the article is in
     */
    String journal;

    /**
     * Stores the the title of the article
     */
    String title;

    /**
     * Stores the month the article was published
     */
    String month;

    /**
     * Stores the year the article was published
     */
    String year;

    /**
     * Stores the volume of the journal the article was published in
     */
    String volume;

    /**
     * Stores the pages the articles are on
     */
    String pages;

    /**
     * Stores the article number
     */
    String number;

    /**
     * Stores the latter part of the articles URL
     */
    String doi;

    /**
     * Stores the count of acm lines outputted currently
     */
    static int count_acm =1;

    /**
     *Default constructor; left blank so class acts like a struct
     */
    public Article(){
    	 //blank
     }

    /**
     * Accessor for authors array
     * @return authors Author names
     */
    public String[] getAuthors() {
        return authors;
    }

    /**
     * Mutator for authors array
     * @param authors Array of author names
     */
    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    /**
     *Accessor for Journal name
     * @return journal The name of the journal
     */
    public String getJournal() {
        return journal;
    }

    /**
     * Mutator for journal name
     * @param journal The name of the journal
     */
    public void setJournal(String journal) {
        this.journal = journal;
    }

    /**
     * Accessor for title
     * @return title The article title
     */
    public String getTitle() {
        return title;
    }

    /**
     *  Muttator for title
     * @param title The title of an article
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Accessor for month
     * @return month The month the article was published
     */
    public String getMonth() {
        return month;
    }

    /**
     * Mutator for month
     * @param month The month the article was published
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * Accessor for year
     * @return year The year the article was published
     */
    public String getYear() {
        return year;
    }

    /**
     * Mutator for year
     * @param year The year the article was published
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Accessor for volume
     * @return volume The volume of the article
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Mutator for volume
     * @param volume The volue of the article
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * The accessor for pages
     * @return pages The number of pages quoted
     */
    public String getPages() {
        return pages;
    }

    /**
     * Mutator for pages
     * @param pages The number of pages quoted
     */
    public void setPages(String pages) {
        this.pages = pages;
    }

    /**
     * Accessor for number
     * @return number, the article number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Mutator for number
     * @param number The article number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Accessor for doi
     * @return doi The latter part of the article URL
     */
    public String getDoi() {
        return doi;
    }

    /**
     * Mutator for doi
     * @param doi The latter part of the article URL
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * Prints the IEEE format
     * @return output, A reference line in IEEE format
     */
    public String printIEEE(){
        String output=authors[0];

        if(authors.length >1) {

            for (int i = 1; i < authors.length; i++) {
                if (i != authors.length - 1) {
                    output = output + ", ";
                }
                output = output + authors[i];
            }
        }
        output = output + ". \""+title+"\", "+journal+", vol."+volume+", no."+number+", p."+pages+", "+month+" "+year+".\n";
        return output;
    }

    /**
     * Prints the ACM format
     * @return output, A reference line in the ACM format
     */
    public String printACM(){

        String output = "[" + count_acm + "] ";
        count_acm++;

        if (authors.length>1){
            output=output+authors[0]+" et al. ";
        }
        else{
            output= output+ authors[0]+". ";
        }
        output= output + year +". "+title+". "+journal+". "+volume + ", "+ number +" ("+year+"), "+pages+". DOI:https://doi.org/"+doi+".\n";
        return output;
    }

    /**
     * Prints the NJ format
     *
     * @return output A reference line in NJ format
     */
    public String printNJ(){
        String output=authors[0];

        if(authors.length >1) {
            for (int i = 1; i < authors.length; i++) {
                if (i != authors.length - 1) {
                    output = output + " & ";
                }
                output = output + authors[i];
            }
        }
        output = output + ". "+title+". "+journal+". "+volume+", "+pages+" ("+year+").\n";
        return output;
    }

} 

