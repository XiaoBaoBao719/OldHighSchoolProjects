using UnityEngine;
using System.Collections;

[RequireComponent(typeof(SpriteRenderer))]

public class Tiling : MonoBehaviour {

    public Parallaxing parallaxList;

    public int offsetX = 2;             //the offset so we don't get wierd errors

    public bool hasRightBuddy = false;  //check whether to Instantiate
    public bool hasLeftBuddy = false;

    public bool reverseScale = false;   //Used if the object is not tiliable

    private float spriteWidth = 0f;     //width of the element
    private Camera cam;
    private Transform myTransform;

    void Awake()
    {
        cam = Camera.main;
        myTransform = transform;
    }

	// Use this for initialization
	void Start () {
	
        SpriteRenderer sRenderer = GetComponent<SpriteRenderer>();
        spriteWidth = sRenderer.sprite.bounds.size.x; //get width of element
	}
	
	// Update is called once per frame
	void Update () {
	
        //Does it still need buddies? If not do nothing
        if(!hasLeftBuddy || !hasRightBuddy)
        {
            //Calculate the camera's extend (half the width) of what the cam can see in world coords (not pixels)
            float camHorizExtent = cam.orthographicSize * Screen.width / Screen.height;

            //Calculate the exposition where the cam can see the edge of he sprite
            float edgeVisiblePositionRight = (myTransform.position.x + spriteWidth/2) - camHorizExtent;
            float edgeVisiblePositionLeft = (myTransform.position.x - spriteWidth/2) + camHorizExtent;

            //check if can see edge of element then call makeNewBuddy() if can
            if(cam.transform.position.x >= edgeVisiblePositionRight - offsetX && !hasRightBuddy)
            {
                makeNewBuddy(1);
                hasRightBuddy = true;
            }
            else if(cam.transform.position.x <= edgeVisiblePositionLeft + offsetX && !hasLeftBuddy)
            {
                makeNewBuddy(-1);
                hasLeftBuddy = true;
            }
        }
	}

    //function that creates a buddy on the side required
    void makeNewBuddy(int dir)
    {
        //Calc new pos of buddy
        Vector3 newPos = new Vector3 ( myTransform.position.x + spriteWidth * dir, myTransform.position.y, myTransform.position.z);
        //Instantiate new buddy and storing in a variable
        Transform newBuddy = Instantiate (myTransform, newPos, myTransform.rotation) as Transform;

        //if not tiliable, reverse the x size of object
        if(reverseScale)
        {
            //invert x scale of element so it loops well
            newBuddy.localScale = new Vector3 (newBuddy.localScale.x * -1, newBuddy.localScale.y, newBuddy.localScale.z);
        }

        newBuddy.parent = myTransform.parent;
        if(dir > 0)
        {
            newBuddy.GetComponent<Tiling>().hasLeftBuddy = true;
        }
        else
        {
            newBuddy.GetComponent<Tiling>().hasRightBuddy = true;
        }
    }
}

