class TextEditor {
    StringBuilder sb ;
    int cursor;
    public TextEditor() {
        sb = new StringBuilder();
        cursor = 0;
    }
    
    public void addText(String text) {
        sb.insert(cursor,text);
        cursor+= text.length();
    }
    
    public int deleteText(int k) {
        int l = Math.max(0,cursor-k);
        int r = cursor;
        sb.delete(l,r);
        cursor = l; 
        return r-l;
    }
    
    public String cursorLeft(int k) {
        if(cursor != 0)
        {
            if(cursor - k  >= 0)
            {
                cursor -= k;
            }
            else
            {
                cursor = 0;
            }
        }
        if(cursor-10 >= 0)
        {
            return sb.substring(cursor-10,cursor);
        }
        else
        {
            return sb.substring(0,cursor);
        }
    }
    
    public String cursorRight(int k) {
        if(cursor != sb.length())
        {
            int len = sb.length() - cursor;
            if(len <= k)
            {
                cursor = sb.length();
            }
            else
            {
                cursor += k;
            }
        }
        if(cursor-10 >= 0)
        {
            return sb.substring(cursor-10,cursor);
        }
        else
        {
            return sb.substring(0,cursor);
        }
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */sss
