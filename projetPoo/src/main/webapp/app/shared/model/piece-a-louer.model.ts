import { IApplicationUser } from 'app/shared/model/application-user.model';
import { IUtilisateur } from 'app/shared/model/utilisateur.model';

export interface IPieceALouer {
  id?: number;
  adresse?: string;
  cheminPhotoPiece?: string | null;
  disponibilite?: boolean;
  prixLocation?: number;
  proprietaire?: string;
  applicationUser?: IApplicationUser | null;
  utilisateur?: IUtilisateur | null;
}

export const defaultValue: Readonly<IPieceALouer> = {
  disponibilite: false,
};
